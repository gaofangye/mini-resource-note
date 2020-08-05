package com.kele.resourcenoteuser.configuration.mybatisplus;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class ResourceGlobalConfig extends GlobalConfig {

    /**
     * 实体类首字母小写名称
     */
    private String entityClassName;

}
