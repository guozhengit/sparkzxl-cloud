package com.github.sparkzxl.authority.interfaces.controller.auth;

import com.github.sparkzxl.core.entity.AuthUserInfo;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.authority.application.service.IAuthRoleService;
import com.github.sparkzxl.authority.infrastructure.entity.AuthRole;
import com.github.sparkzxl.authority.interfaces.dto.role.AuthRolePageDTO;
import com.github.sparkzxl.authority.interfaces.dto.role.AuthRoleSaveDTO;
import com.github.sparkzxl.authority.interfaces.dto.role.AuthRoleUpdateDTO;
import com.github.sparkzxl.web.annotation.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * description: 角色 前端控制器
 *
 * @author zhouxinlei
 * @date 2020-06-07 13:40:03
 */
@RestController
@RequestMapping("/role")
@ResponseResult
@WebLog
@Api(tags = "角色管理")
public class AuthRoleController extends SuperCacheController<IAuthRoleService, Long,
        AuthRole, AuthRolePageDTO, AuthRoleSaveDTO, AuthRoleUpdateDTO> {

    @Override
    public boolean handlerDelete(List<Long> ids) {
        baseService.deleteAuthRoleRelation(ids);
        return true;
    }

    @ApiOperation("更新角色状态")
    @PatchMapping("/role/{id}")
    public boolean updateAuthRoleStatus(@ApiIgnore AuthUserInfo authUserInfo, @PathVariable("id") Long id,
                                        @RequestParam(value = "status") Boolean status) {
        return baseService.updateAuthRoleStatus(authUserInfo.getId(), id, status);
    }


}
