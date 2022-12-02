package com.hello.springbootmultisource.entity.groups;

import javax.validation.groups.Default;

public interface UserGroups {

    /**
     * 1。 分组只能定义为接口，否则报错
     * 2。 需要继承javax.validation.groups.Default,
     *      否则没有加groups的其他约束将被视为其他分组
     */

    interface AddValidationGroup extends Default {}
    interface UpdateValidationGroup extends Default {}
}
