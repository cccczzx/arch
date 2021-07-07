package com.zhangzixiang.bridge.controller;


import com.zhangzixiang.bridge.entity.ArchAssetTypePo;
import com.zhangzixiang.bridge.model.ArchAssetTypeInVo;
import com.zhangzixiang.bridge.service.ArchAssetTypeService;
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

@Api(tags = "查询桥梁仪器设备类型信息")
@RestController
@RequestMapping(value="/archAssetType")
@Slf4j
public class ArchAssetTypeController {

    @Resource
    private ArchAssetTypeService archAssetTypeService ;

    @GetMapping(value = "/findArchAssetTypeList")
    @ApiOperation(value = "查询桥梁仪器设备类型列表", notes = "查询桥梁仪器设备类型列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value="桥梁名称", name="bridgeName", paramType = "query", required = true)
    })
    public HttpResponse<List<ArchAssetTypePo>> findArchAssetTypeList(String bridgeName) {
        return archAssetTypeService.findArchAssetTypeList(bridgeName) ;
    }

    @GetMapping(value = "/findArchAssetTypePage")
    @ApiOperation(value = "查询桥梁仪器设备类型信息", notes = "查询桥梁仪器设备类型信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "类型名称", name = "typeName", paramType = "query"),
            @ApiImplicitParam(value = "分页大小", name = "pageSize", paramType = "query", required = true),
            @ApiImplicitParam(value = "页码", name = "pageNum", paramType = "query", required = true)
    })
    public HttpResponse<Page<ArchAssetTypePo>> findArchAssetTypePage(String typeName, Integer pageSize, Integer pageNum) {
        return archAssetTypeService.findArchAssetTypePage(typeName, pageSize,pageNum) ;
    }

    @PostMapping(value="/saveArchAssetType")
    @ApiOperation(value = "保存桥梁仪器设备类型信息", notes = "保存桥梁仪器设备类型信息")
    public HttpResponse<String> saveArchAssetType (HttpServletRequest request, @RequestBody ArchAssetTypeInVo archAssetTypeInVo) {
        return archAssetTypeService.save(archAssetTypeInVo) ;
    }

    @GetMapping(value = "/deleteArchAssetType/{id}")
    @ApiOperation(value = "删除桥梁仪器设备类型信息", notes = "删除桥梁仪器设备类型信息")
    public HttpResponse<String> deleteArchAssetType (HttpServletRequest request, @PathVariable("id") Integer id) {
        return archAssetTypeService.delete(id) ;
    }




}
