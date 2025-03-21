package com.study.controller.client;

import com.study.service.PostCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/postCategory")
@Slf4j
public class PostCategoryController {

    @Autowired
    private PostCategoryService postCategoryService;
}
