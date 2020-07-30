package com.kele.resourcenotebusiness.controller;


import com.kele.resourcenotebusiness.domain.dto.business.ShareDTO;
import com.kele.resourcenotebusiness.domain.dto.user.UserDTO;
import com.kele.resourcenotebusiness.domain.entity.share.Share;
import com.kele.resourcenotebusiness.service.IShareService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 分享表 前端控制器
 * </p>
 *
 * @author gaofangye
 * @since 2020-07-24
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/share")
public class ShareController {

    private @NonNull
    final IShareService shareService;
    private @NonNull RestTemplate restTemplate;


    @GetMapping("{id}")
    public ShareDTO findById(@PathVariable Long id) {
        Share share = shareService.getById(id);

        UserDTO userDTO = restTemplate.getForObject(
                "http://localhost:29001/user/1",
                UserDTO.class
        );

        ShareDTO shareDTO = ShareDTO.builder().build();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }
}

