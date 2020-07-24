package com.kele.resourcenoteuser.service.impl;

import com.kele.resourcenoteuser.domain.entity.user.User;
import com.kele.resourcenoteuser.dao.UserDao;
import com.kele.resourcenoteuser.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author gaofangye
 * @since 2020-07-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
