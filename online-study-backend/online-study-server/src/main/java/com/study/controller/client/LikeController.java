package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.dto.LikeDTO;
import com.study.result.Result;
import com.study.service.LikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/like")
@Slf4j
public class LikeController {

    @Autowired
    private LikeService likeService;

    /**
     * 新增点赞
     *
     * @param likeDTO 点赞DTO对象
     */
    @PutMapping("/add")
    public Result<String> add(@RequestBody LikeDTO likeDTO) {
        likeService.add(likeDTO);
        log.info("C端用户(id:{})新增收藏:{}", BaseContext.getCurrentId(), likeDTO);
        return Result.success();
    }
}
