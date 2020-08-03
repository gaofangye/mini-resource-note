package com.kele.resourcenotebusiness.controller;


import com.kele.resourcenotebusiness.domain.dto.business.ShareDTO;
import com.kele.resourcenotebusiness.domain.dto.user.UserDTO;
import com.kele.resourcenotebusiness.domain.entity.share.Share;
import com.kele.resourcenotebusiness.service.IShareService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * <p>
 * 分享表 前端控制器
 * </p>
 *
 * @author gaofangye
 * @since 2020-07-24
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/share")
public class ShareController {

    private @NonNull
    final IShareService shareService;
    private @NonNull
    final RestTemplate restTemplate;
    private @NonNull
    final DiscoveryClient discoveryClient;


    @GetMapping("{id}")
    public ShareDTO findById(@PathVariable Long id) {
        Share share = shareService.getById(id);

        List<ServiceInstance> instances = discoveryClient.getInstances("mini-resource-user");
        List<String> urlList = instances.stream().map(instance -> instance.getUri().toString() + "/user/1")
                .collect(Collectors.toList());

        int number = ThreadLocalRandom.current().nextInt(urlList.size());
        String requestUrl = urlList.get(number);
        log.debug("请求用户中心地址：" + requestUrl);
        UserDTO userDTO = restTemplate.getForObject(
                requestUrl,
                UserDTO.class
        );

        ShareDTO shareDTO = ShareDTO.builder().build();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }
}

