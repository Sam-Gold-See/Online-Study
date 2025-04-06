package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.dto.LikeDTO;
import com.study.result.Result;
import com.study.service.LikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/like")
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
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
        log.info("C端用户(id:{})新增点赞:{}", BaseContext.getCurrentId(), likeDTO);
        return Result.success();
    }

    /**
     * 删除点赞
     *
     * @param likeDTO 点赞DTO对象
     */
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody LikeDTO likeDTO) {
        likeService.delete(likeDTO);
        log.info("C端用户(id:{})删除点赞{}", BaseContext.getCurrentId(), likeDTO);
        return Result.success();
    }

    /**
     * 查询帖子点赞情况
     *
     * @param likeDTO 点赞DTO对象
     */
    @GetMapping
    public Result<String> get(@RequestBody LikeDTO likeDTO) {
        Integer result = likeService.get(likeDTO);
        log.info("C端用户(id:{})正在查询{}点赞情况", BaseContext.getCurrentId(), likeDTO);
        return Result.success(result.toString());
    }
}
