package com.study.conrtoller.user;

import com.study.service.ClientUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/user")
@Slf4j
public class ClientUserController {

    @Autowired
    ClientUserService clientUserService;
}
