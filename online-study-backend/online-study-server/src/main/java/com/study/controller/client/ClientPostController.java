package com.study.controller.client;

import com.study.dto.post.PostDTO;
import com.study.result.Result;
import com.study.service.PostService;
import com.study.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("ClientPostController")
@RequestMapping("/client/post")
@Slf4j
public class ClientPostController {

    @Autowired
    private PostService postService;

    /**
     * 新增帖子
     *
     * @param postDTO 帖子DTO对象
     * @return Result类响应对象
     */
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody PostDTO postDTO) {
        postService.insert(postDTO);
        return Result.success();
    }

    /**
     * 获取帖子信息
     *
     * @param id 帖子Id
     * @return Result类响应对象
     */
    @GetMapping("/get")
    public Result<PostVO> get(Long id) {
        PostVO postVO = postService.get(id);
        return Result.success(postVO);
    }

    /**
     * 修改帖子信息
     *
     * @param postDTO 帖子DTO对象
     * @return Result类响应对象
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody PostDTO postDTO) {
        postService.update(postDTO);
        return Result.success();
    }

    /**
     * 删除帖子
     *
     * @param id 帖子id
     * @return Result类响应对象
     */
    @GetMapping("/delete")
    public Result<String> delete(Long id) {
        postService.delete(id);
        return Result.success();
    }
}