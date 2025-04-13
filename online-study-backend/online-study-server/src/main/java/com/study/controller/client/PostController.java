package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.dto.PostDTO;
import com.study.dto.PostPageQueryDTO;
import com.study.result.PageResult;
import com.study.result.Result;
import com.study.service.PostService;
import com.study.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/client/post")
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 新增帖子
     *
     * @param postDTO 帖子DTO对象
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody PostDTO postDTO) {
        log.info("C端用户(id:{})新增帖子:{}", BaseContext.getCurrentId(), postDTO);
        postService.add(postDTO);
        return Result.success();
    }

    /**
     * 获取帖子信息
     *
     * @param id 帖子id
     */
    @GetMapping("/get")
    public Result<PostVO> get(Long id) {
        log.info("C端用户(id:{})查看帖子:{}", BaseContext.getCurrentId(), id);
        PostVO postVO = postService.get(id);
        return Result.success(postVO);
    }

    /**
     * 删除帖子
     *
     * @param id 帖子id
     */
    @DeleteMapping("/delete")
    public Result<String> delete(Long id) {
        log.info("C端用户(id:{})删除帖子:{}", BaseContext.getCurrentId(), id);
        postService.delete(id);
        return Result.success();
    }

    /**
     * 修改帖子
     *
     * @param postDTO 帖子DTO对象
     */
    @PostMapping("/editPost")
    public Result<String> edit(@RequestBody PostDTO postDTO) {
        log.info("C端用户(id:{})修改帖子:{}", BaseContext.getCurrentId(), postDTO);
        postService.editPost(postDTO);
        return Result.success();
    }

    /**
     * 帖子分页查询
     *
     * @param postPageQueryDTO 帖子分页查询DTO
     */
    @GetMapping("/query")
    public Result<PageResult<PostVO>> query(@RequestBody PostPageQueryDTO postPageQueryDTO) {
        log.info("帖子分页查询，条件为:{}", postPageQueryDTO);
        PageResult<PostVO> pageResult = postService.query(postPageQueryDTO);
        return Result.success(pageResult);
    }
}