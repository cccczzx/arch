package com.zhangzixiang.bridge.controller;

import com.zhangzixiang.bridge.entity.ArchBridgePo;
import com.zhangzixiang.bridge.model.ArchBridgeInVo;
import com.zhangzixiang.bridge.service.ArchBridgeService;
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
import java.util.List;

@Api (tags = "查询桥梁信息")
@RestController
@RequestMapping (value = "/archBridge")
@Slf4j
public class ArchBridgeController {

    @Resource
    private ArchBridgeService archBridgeService ;

    @GetMapping(value = "/findArchBridgeList")
    @ApiOperation(value = "查询桥梁列表", notes = "查询桥梁列表")
    public HttpResponse<List<ArchBridgePo>> findArchBridgeList() {
        return archBridgeService.findBridgeList() ;
    }

    @GetMapping(value = "/findArchBridgePage")
    @ApiOperation(value = "查询桥梁信息", notes = "查询桥梁信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value="桥梁名称", name="bridgeName", paramType = "query"),
            @ApiImplicitParam(value="分页大小", name="pageSize", paramType = "query", required = true),
            @ApiImplicitParam(value = "页码", name="pageNum", paramType = "query", required = true)
    })
    public HttpResponse<Page<ArchBridgePo>> findArchBridgePage(String bridgeName, int pageSize, int pageNum) {
        return  archBridgeService.findBridgePage(bridgeName, pageSize, pageNum) ;
    }

    @PostMapping(value = "/saveArchBridge")
    @ApiOperation(value = "保存桥梁信息" ,notes = "保存桥梁信息")
    public HttpResponse<String> saveArchBridge(HttpServletRequest request, @RequestBody  ArchBridgeInVo archBridgeInVo){
        return archBridgeService.save(archBridgeInVo) ;
    }

    @GetMapping(value = "/deleteArchBridge/{id}")
    @ApiOperation(value = "删除桥梁信息", notes = "删除桥梁信息")
    public HttpResponse<String> deleteArchBridge(HttpServletRequest request, @PathVariable("id") Integer id) {
        return archBridgeService.delete(id) ;
    }


}
