package com.study.service;

import com.study.vo.NotificationVO;

import java.util.List;

public interface NotificationService {

    /**
     * 查询通知
     */
    List<NotificationVO> getList();

    /**
     * 已读通知
     *
     * @param id 通知id
     */
    void delete(Long id);

    /**
     * 全部已读
     */
    void readAll();
}
