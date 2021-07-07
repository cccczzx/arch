package com.zhangzixiang.bridge.repo;

import com.zhangzixiang.bridge.entity.ArchBridgePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArchBridgeRepo extends JpaRepository<ArchBridgePo, Integer>, JpaSpecificationExecutor<ArchBridgePo> {

}
