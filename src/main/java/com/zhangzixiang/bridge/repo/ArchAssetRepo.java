package com.zhangzixiang.bridge.repo;

import com.zhangzixiang.bridge.entity.ArchAssetPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ArchAssetRepo extends JpaRepository<ArchAssetPo, Integer>, JpaSpecificationExecutor<ArchAssetPo> {

    List<ArchAssetPo> findBySectionId(Integer sectionId) ;

}
