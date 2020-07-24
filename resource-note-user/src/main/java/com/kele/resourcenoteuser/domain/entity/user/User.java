package com.kele.resourcenoteuser.domain.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author gaofangye
 * @since 2020-07-23
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 微信id
     */
    private String wxId;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 角色
     */
    private String roles;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 积分
     */
    private Integer bonus;

    private Integer version;


}
