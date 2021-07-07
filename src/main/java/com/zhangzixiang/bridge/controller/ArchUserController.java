package com.zhangzixiang.bridge.controller;

import com.zhangzixiang.bridge.entity.ArchUserPo;
import com.zhangzixiang.bridge.model.ArchUserInVo;
import com.zhangzixiang.bridge.service.ArchUserService;
import com.zhangzixiang.bridge.util.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "查询用户信息")
@RestController
@RequestMapping (value = "/archUser")
@Slf4j
public class ArchUserController {

    @Resource
    private ArchUserService archUserService ;

    @GetMapping(value = "/findArchUserPage")
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "手机", name="phone", paramType = "query"),
            @ApiImplicitParam(value = "分页大小", name="pageSize", paramType = "query", required = true),
            @ApiImplicitParam(value = "页码", name="pageNum", paramType = "query", required = true)
    })
    public HttpResponse<Page<ArchUserPo>> findArchUserPage(String phone, int pageSize, int pageNum){
        return archUserService.findArchUserPage(phone, pageSize, pageNum) ;
    }

    @PostMapping(value = "/saveArchUser")
    @ApiOperation(value = "保存用户信息", notes = "保存用户信息")
    public HttpResponse<ArchUserPo> saveArchUser (HttpServletRequest request, @RequestBody ArchUserInVo archUserInVo) {
        return archUserService.saveUser(archUserInVo) ;
    }

    @GetMapping(value = "/deleteArchUser/{id}")
    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    public HttpResponse<String> deleteArchUser(HttpServletRequest request, @PathVariable("id") Integer id){
        return archUserService.deleteUser(id) ;
    }


}
