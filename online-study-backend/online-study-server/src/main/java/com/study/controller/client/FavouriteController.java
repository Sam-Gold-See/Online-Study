package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.dto.FavouriteDTO;
import com.study.dto.FavouritePageQueryDTO;
import com.study.entity.Favourite;
import com.study.result.PageResult;
import com.study.result.Result;
import com.study.service.FavouriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/favourite")
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    /**
     * 新增收藏
     *
     * @param favouriteDTO 收藏DTO对象
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody FavouriteDTO favouriteDTO) {
        log.info("C端用户(id:{})新增收藏:{}", BaseContext.getCurrentId(), favouriteDTO);
        favouriteService.add(favouriteDTO);
        return Result.success();
    }

    /**
     * 删除收藏
     *
     * @param favouriteDTO 收藏DTO对象
     */
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody FavouriteDTO favouriteDTO) {
        log.info("C端用户(id:{})删除收藏:{}", BaseContext.getCurrentId(), favouriteDTO);
        favouriteService.delete(favouriteDTO);
        return Result.success();
    }

    /**
     * 分页查询
     *
     * @param favouritePageQueryDTO 收藏分页查询DTO对象
     */
    @GetMapping("/query")
    public Result<PageResult<Favourite>> query(@RequestBody FavouritePageQueryDTO favouritePageQueryDTO) {
        log.info("C端用户(id:{})查询收藏列表)", BaseContext.getCurrentId());
        PageResult<Favourite> pageResult = favouriteService.query(favouritePageQueryDTO);
        return Result.success(pageResult);
    }
}
