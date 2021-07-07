package com.zhangzixiang.bridge.controller;

import com.zhangzixiang.bridge.entity.ArchAssetPo;
import com.zhangzixiang.bridge.model.ArchAssetInVo;
import com.zhangzixiang.bridge.service.ArchAssetService;
import com.zhangzixiang.bridge.util.HttpResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping (value = "/archAsset")
@Slf4j
public class ArchAssetController {

    @Resource
    private ArchAssetService archAssetService ;

    @GetMapping(value = "/findArchAssetPage")
    @ApiOperation(value = "查询桥梁仪器设备信息", notes = "查询桥梁仪器设备信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value="桥梁名称", name="bridgeName", paramType = "query"),
            @ApiImplicitParam(value = "截面名称", name="sectionName", paramType = "query"),
            @ApiImplicitParam(value="分页大小", name="pageSize", required = true, paramType = "query"),
            @ApiImplicitParam(value="页码", name="pageNum", paramType = "query", required = true)
    })
    public HttpResponse<Page<ArchAssetPo>> findArchAssetPage(String bridgeName, String sectionName, int pageSize, int pageNum) {
        return archAssetService.findArchAssetPoPage(bridgeName, sectionName, pageSize, pageNum) ;
    }

    @GetMapping(value = "/findArchAssetList")
    @ApiOperation(value = "查询桥梁仪器设备列表", notes = "查询桥梁仪器设备列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "截面名称", name="sectionId", required = true, paramType = "query")
    })
    public HttpResponse<List<ArchAssetPo>> findArchAssetList(Integer sectionId) {
        return archAssetService.findArchAssetPoList(sectionId) ;
    }

    @PostMapping(value="/saveArchAsset")
    @ApiOperation(value="保存桥梁仪器设备信息", notes="保存桥梁仪器设备信息")
    public HttpResponse<String> saveArchAsset(HttpServletRequest request, @RequestBody ArchAssetInVo archAssetInVo) {
        return archAssetService.save(archAssetInVo);
    }

    @GetMapping(value="/deleteArchAsset/{id}")
    @ApiOperation(value="删除桥梁仪器设备信息", notes = "删除桥梁仪器设备信息")
    public HttpResponse<String> deleteArchAsset(HttpServletRequest request, @PathVariable("id") Integer id){
        return archAssetService.delete(id) ;
    }


}
