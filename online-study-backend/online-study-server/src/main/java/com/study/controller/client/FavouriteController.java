package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.dto.FavouriteDTO;
import com.study.result.Result;
import com.study.service.FavouriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/favourite")
@Slf4j
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
        favouriteService.add(favouriteDTO);
        log.info("C端用户(id:{})新增收藏:{}", BaseContext.getCurrentId(), favouriteDTO);
        return Result.success();
    }

    /**
     * 删除收藏
     *
     * @param favouriteDTO 收藏DTO对象
     */
    @DeleteMapping("/delete")
    public Result<String> delete(@RequestBody FavouriteDTO favouriteDTO) {
        favouriteService.delete(favouriteDTO);
        log.info("C端用户(id:{})删除收藏：{}", BaseContext.getCurrentId(), favouriteDTO);
        return Result.success();
    }
}
