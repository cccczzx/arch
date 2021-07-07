package com.zhangzixiang.bridge.repo;

import com.zhangzixiang.bridge.entity.ArchMonitorRecordPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArchMonitorRecordRepo extends JpaRepository<ArchMonitorRecordPo, Integer>, JpaSpecificationExecutor<ArchMonitorRecordPo> {

}
