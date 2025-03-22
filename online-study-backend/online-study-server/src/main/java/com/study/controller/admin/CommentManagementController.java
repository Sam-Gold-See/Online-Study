package com.study.controller.admin;

import com.study.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/comment")
@Slf4j
public class CommentManagementController {

    @Autowired
    private CommentService commentService;
}
