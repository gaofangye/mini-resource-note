package com.kele.resourcenoteuser.service.impl;

import com.kele.resourcenoteuser.domain.entity.user.BonusEventLog;
import com.kele.resourcenoteuser.dao.BonusEventLogDao;
import com.kele.resourcenoteuser.service.IBonusEventLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 积分变更记录表 服务实现类
 * </p>
 *
 * @author gaofangye
 * @since 2020-07-24
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BonusEventLogServiceImpl extends ServiceImpl<BonusEventLogDao, BonusEventLog> implements IBonusEventLogService {

}
