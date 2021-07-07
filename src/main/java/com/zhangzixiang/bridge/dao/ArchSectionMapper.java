package com.zhangzixiang.bridge.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangzixiang.bridge.entity.ArchAssetPo;
import com.zhangzixiang.bridge.entity.ArchSectionPo;
import com.zhangzixiang.bridge.model.ArchSectionOutVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArchSectionMapper extends BaseMapper<ArchSectionPo> {

    List<ArchSectionOutVo> findArchSectionList(@Param("typeId") Integer typeId) ;

}
