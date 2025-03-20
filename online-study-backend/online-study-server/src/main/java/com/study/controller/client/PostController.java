package com.study.controller.client;

import com.study.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client/post")
@RestController
@Slf4j
public class PostController {

    @Autowired
    private PostService postService;
}
