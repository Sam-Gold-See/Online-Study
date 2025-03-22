package com.study.controller.client;

import com.study.service.LikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/like")
@Slf4j
public class LikeController {

    @Autowired
    private LikeService likeService;
}
