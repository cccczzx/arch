package com.zhangzixiang.bridge.repo;

import com.zhangzixiang.bridge.entity.ArchUserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArchUserRepo extends JpaRepository<ArchUserPo, Integer>, JpaSpecificationExecutor<ArchUserPo> {
    ArchUserPo findByName(String username);
}
