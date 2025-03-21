package com.study.controller.admin;

import com.study.service.PostCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin/postCategory")
public class PostCategoryManagementController {

    @Autowired
    private PostCategoryService postCategoryService;
}
