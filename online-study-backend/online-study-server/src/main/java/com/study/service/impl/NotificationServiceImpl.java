package com.study.service.impl;

import com.study.constant.NotificationConstant;
import com.study.context.BaseContext;
import com.study.entity.Notification;
import com.study.mapper.NotificationMapper;
import com.study.service.NotificationService;
import com.study.vo.NotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public List<NotificationVO> getList() {
        Notification notification = Notification.builder()
                .toId(BaseContext.getCurrentId())
                .status(NotificationConstant.UNREAD)
                .build();
        return notificationMapper.getList(notification);
    }
}
