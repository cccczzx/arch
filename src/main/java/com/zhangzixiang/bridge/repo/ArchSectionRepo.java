package com.zhangzixiang.bridge.repo;

import com.zhangzixiang.bridge.entity.ArchSectionPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArchSectionRepo extends JpaRepository<ArchSectionPo, Integer>, JpaSpecificationExecutor<ArchSectionPo> {

}
