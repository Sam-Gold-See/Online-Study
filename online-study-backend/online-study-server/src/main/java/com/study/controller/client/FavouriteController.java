package com.study.controller.client;

import com.study.service.FavouriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/favourite")
@Slf4j
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;


}
