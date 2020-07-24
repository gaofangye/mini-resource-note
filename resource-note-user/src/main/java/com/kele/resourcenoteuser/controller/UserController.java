package com.kele.resourcenoteuser.controller;


import com.kele.resourcenoteuser.dao.UserDao;
import com.kele.resourcenoteuser.domain.entity.user.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author gaofangye
 * @since 2020-07-23
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private @NonNull
    final UserDao userDao;

    @GetMapping("/test")
    public User test() {
        User user = User.builder()
                .wxNickname("123")
                .bonus(123).build();
        return user;
    }
}

