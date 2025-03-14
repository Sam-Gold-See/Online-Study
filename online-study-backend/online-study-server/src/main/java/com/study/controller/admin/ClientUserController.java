package com.study.controller.admin;

import com.study.dto.clientuser.ClientUserPageQueryDTO;
import com.study.entity.ClientUser;
import com.study.result.PageResult;
import com.study.result.Result;
import com.study.service.ClientUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("bClientUserController")
@RequestMapping("/admin/clientUser")
@Slf4j
public class ClientUserController {

    @Autowired
    private ClientUserService clientUserService;

    /**
     * C端用户分页查询
     *
     * @param clientUserPageQueryDTO C端用户分页查询DTO对象
     * @return Result类响应对象
     */
    @GetMapping("/page")
    public Result<PageResult<ClientUser>> getClientListPage(ClientUserPageQueryDTO clientUserPageQueryDTO) {
        PageResult<ClientUser> pageResult = clientUserService.getClientListPage(clientUserPageQueryDTO);
        return Result.success(pageResult);
    }
}
