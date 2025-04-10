package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.result.Result;
import com.study.service.NotificationService;
import com.study.vo.NotificationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
