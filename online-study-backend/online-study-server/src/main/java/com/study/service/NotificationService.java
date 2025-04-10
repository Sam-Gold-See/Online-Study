package com.study.service;

import com.study.vo.NotificationVO;

import java.util.List;

public interface NotificationService {

    /**
     * 查询通知
     */
    List<NotificationVO> getList();
}
