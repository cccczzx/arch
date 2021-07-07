package com.zhangzixiang.bridge.repo;

import com.zhangzixiang.bridge.entity.ArchAssetTypePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ArchAssetTypeRepo extends JpaRepository<ArchAssetTypePo, Integer>, JpaSpecificationExecutor<ArchAssetTypePo> {

    List<ArchAssetTypePo> findByBridgeName(String bridgeName) ;

}
