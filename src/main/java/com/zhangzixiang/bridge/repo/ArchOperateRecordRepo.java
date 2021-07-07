package com.zhangzixiang.bridge.repo;

import com.zhangzixiang.bridge.entity.ArchOperateRecordPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArchOperateRecordRepo extends JpaRepository<ArchOperateRecordPo, Integer>, JpaSpecificationExecutor<ArchOperateRecordPo> {

}
