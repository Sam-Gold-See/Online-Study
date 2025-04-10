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

    /**
     * 查询通知
     */
    @Override
    public List<NotificationVO> getList() {
        Notification notification = Notification.builder()
                .toId(BaseContext.getCurrentId())
                .status(NotificationConstant.UNREAD)
                .build();
        return notificationMapper.getList(notification);
    }

    /**
     * 已读通知
     *
     * @param id 通知id
     */
    @Override
    public void delete(Long id) {
        Notification notification = Notification.builder()
                .id(id)
                .status(NotificationConstant.READ)
                .build();
        notificationMapper.update(notification);
    }

    /**
     * 全部已读
     */
    @Override
    public void readAll() {
        notificationMapper.readAll(Notification.builder()
                .status(NotificationConstant.READ)
                .toId(BaseContext.getCurrentId())
                .build());
    }
}
