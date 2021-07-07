package com.zhangzixiang.bridge.repo;

import com.zhangzixiang.bridge.entity.ArchMonitorDataPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArchMonitorDataRepo extends JpaRepository<ArchMonitorDataPo, Integer>, JpaSpecificationExecutor<ArchMonitorDataPo> {

}
