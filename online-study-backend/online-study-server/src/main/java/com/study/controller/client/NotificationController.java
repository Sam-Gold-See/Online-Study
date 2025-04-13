package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.result.Result;
import com.study.service.NotificationService;
import com.study.vo.NotificationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/notification")
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    /**
     * 查询通知
     */
    @GetMapping
    public Result<List<NotificationVO>> getList() {
        List<NotificationVO> list = notificationService.getList();
        log.info("C端用户(id:{})查询通知:{}", BaseContext.getCurrentId(), list);
        return Result.success(list);
    }

    /**
     * 已读通知
     *
     * @param id 通知id
     */
    @DeleteMapping
    public Result<String> delete(Long id) {
        log.info("C端用户(id:{})已读通知:{}", BaseContext.getCurrentId(), id);
        notificationService.delete(id);
        return Result.success();
    }

    /**
     * 全部已读
     */
    @DeleteMapping("/all")
    public Result<String> deleteAll() {
        log.info("C端用户(id:{})全部通知已读", BaseContext.getCurrentId());
        notificationService.readAll();
        return Result.success();
    }
}
