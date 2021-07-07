package com.zhangzixiang.bridge.controller;

import com.zhangzixiang.bridge.entity.ArchSectionPo;
import com.zhangzixiang.bridge.model.ArchSectionInVo;
import com.zhangzixiang.bridge.model.ArchSectionOutVo;
import com.zhangzixiang.bridge.service.ArchSectionService;
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

@Api(tags="查询桥梁截面信息")
@RestController
@RequestMapping (value = "/archSection")
@Slf4j
public class ArchSectionController {

    @Resource
    private ArchSectionService archSectionService ;

    @GetMapping(value = "/findArchSectionList")
    @ApiOperation(value = "查询桥梁截面列表", notes = "查询桥梁截面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "传感器类型", name = "typeId", paramType = "query", required = true)
    })
    public HttpResponse<List<ArchSectionOutVo>> findArchSectionList(Integer typeId) {
        return archSectionService.findArchSectionList(typeId)  ;
    }

    @GetMapping(value = "/findArchSectionPage")
    @ApiOperation(value = "查询桥梁截面信息", notes = "查询桥梁截面信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "桥梁名称", name = "bridgeName", paramType = "query"),
            @ApiImplicitParam(value = "分页大小", name="pageSize", paramType = "query", required = true),
            @ApiImplicitParam(value = "页码", name = "pageNum", paramType = "query", required = true)
    })
    public HttpResponse<Page<ArchSectionPo>> findArchSectionPage(String bridgeName, int pageSize, int pageNum) {
        return archSectionService.findArchSectionPage(bridgeName, pageSize, pageNum) ;
    }

    @PostMapping(value = "/saveArchSection")
    @ApiOperation(value = "保存桥梁截面信息", notes = "保存桥梁截面信息")
    public HttpResponse<String> saveArchSection(HttpServletRequest request, @RequestBody ArchSectionInVo archSectionInVo) {
        return archSectionService.save(archSectionInVo) ;
    }

    @GetMapping(value = "/deleteArchSection/{id}")
    @ApiOperation(value="删除桥梁截面信息", notes = "删除桥梁截面信息")
    public HttpResponse<String> deleteArchSection(HttpServletRequest request, @PathVariable("id") Integer id) {
        return archSectionService.delete(id) ;
    }


}
