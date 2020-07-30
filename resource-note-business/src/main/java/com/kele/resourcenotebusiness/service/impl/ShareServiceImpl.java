package com.kele.resourcenotebusiness.service.impl;

import com.kele.resourcenotebusiness.domain.entity.share.Share;
import com.kele.resourcenotebusiness.dao.ShareDao;
import com.kele.resourcenotebusiness.service.IShareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分享表 服务实现类
 * </p>
 *
 * @author gaofangye
 * @since 2020-07-24
 */
@Service
public class ShareServiceImpl extends ServiceImpl<ShareDao, Share> implements IShareService {

}
