package com.study.controller.admin;

import com.study.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/post")
@RestController
@Slf4j
public class PostManagementController {

    @Autowired
    private PostService postService;
}
