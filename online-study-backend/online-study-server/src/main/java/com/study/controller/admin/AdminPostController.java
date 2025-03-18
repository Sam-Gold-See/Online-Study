package com.study.controller.admin;


import com.study.dto.post.PostPageQueryDTO;
import com.study.enumeration.TerminalType;
import com.study.result.PageResult;
import com.study.result.Result;
import com.study.service.PostService;
import com.study.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminPostController")
@RequestMapping("/admin/post")
@Slf4j
public class AdminPostController {

    @Autowired
    private PostService postService;

    /**
     * 分页查询
     *
     * @param postPageQueryDTO 帖子分页查询DTO对象
     * @return Result类响应对象
     */
    @GetMapping("/page")
    public Result<PageResult<PostVO>> pageQuery(PostPageQueryDTO postPageQueryDTO) {
        PageResult<PostVO> pageResult = postService.PageQuery(postPageQueryDTO, TerminalType.ADMIN);
        return Result.success(pageResult);
    }

    /**
     * 置顶帖子
     *
     * @param id     帖子id
     * @param type 置顶状态
     */
    @PutMapping("/type")
    public Result<String> setType(Long id, Integer type) {
        postService.setType(id, type);
        return Result.success();
    }
}
