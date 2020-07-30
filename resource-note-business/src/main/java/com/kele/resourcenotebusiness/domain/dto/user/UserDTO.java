package com.kele.resourcenotebusiness.domain.dto.user;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Data
public class UserDTO implements Serializable {

    /**
     * 微信昵称
     */
    private String wxNickname;

}
