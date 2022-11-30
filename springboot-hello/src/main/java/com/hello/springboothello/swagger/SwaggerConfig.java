package com.hello.springboothello.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 参考： https://blog.51cto.com/u_15298624/3088270 以及 pdai
 *
 * 添加Swagger配置之后，打开url
 *  http://localhost:8090/swagger-ui/index.html
 *
 * 在Controller中添加ApiOperation注解
 * @ApiOperator(value="接口名", httpMethod="请求方式"，notes="详细说明")
 */
@Configuration
@EnableOpenApi
//@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置Swagger docket bean实例
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("Test group") // 配置分组
                // .enable(false)  是否启动Swagger，false 表示不启动
                .select()
                /**
                 * RequestHandlerSelectors 配置要扫描接口的方式
                 *      basePackage: 指定要扫描的包=》RequestHandlerSelectors.basePackage("com.xx.swagger.controller");
                 *      any(): 扫描全部
                 *      none(): 全部不扫描
                 *      withClassAnnotation：扫描类上的注解 =》RequestHandlerSelectors.withClassAnnotation(RestController.class);
                 *      withMethodAnnotation: 扫描方法上的注解 =》RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)
                 */
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                /**
                 * Path: 过滤路径
                 *      ant： 指定路径
                 *      any： 过滤全部
                 *      none： 全部不过滤
                 *      regex： 按照正则表达式来过滤
                 */
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置swagger 信息 ApiInfo
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("文档标题")                      // 文档标题
                .description("这是一个Swagger接口文档")  // 文档描述
                .version("v1.0")    // 文档版本
                .termsOfServiceUrl("https://xx.wx.com") // 队伍的网站地址
                // 作者信息
                .contact(new Contact("Wesley", "https://xx.wx.com", "838219587@qq.com"))
                .license("Apache 2.0")  // 许可证
                .licenseUrl("https://www.apache.org.licenses/LICENSE-2.0") // 许可证URL
                .build();
    }
}
