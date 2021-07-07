package com.zhangzixiang.bridge.service;

import com.zhangzixiang.bridge.entity.ArchBridgePo;
import com.zhangzixiang.bridge.entity.ArchUserPo;
import com.zhangzixiang.bridge.model.ArchBridgeInVo;
import com.zhangzixiang.bridge.repo.ArchBridgeRepo;
import com.zhangzixiang.bridge.util.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;


@Service
public class ArchBridgeService {

    @Resource
    private ArchBridgeRepo archBridgeRepo ;

    public HttpResponse<List<ArchBridgePo>> findBridgeList() {
        List<ArchBridgePo> archBridgePoList ;
        archBridgePoList = archBridgeRepo.findAll() ;
        return HttpResponse.SUCCESS(archBridgePoList) ;
    }

    public HttpResponse<Page<ArchBridgePo>> findBridgePage(String bridgeName, int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime") ;
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, sort) ;
        Page<ArchBridgePo> archBridgePos = archBridgeRepo.findAll((Specification<ArchBridgePo>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction() ;
            if (!StringUtils.isEmpty(bridgeName)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("bridgeName"), "%"+bridgeName+"%"));
            }
            return predicate ;
        }, pageRequest) ;
        return HttpResponse.SUCCESS(archBridgePos) ;
    }

    public HttpResponse<String> save(ArchBridgeInVo archBridgeInVo) {
        ArchBridgePo archBridgePo = new ArchBridgePo() ;
        BeanUtils.copyProperties(archBridgeInVo, archBridgePo);
        ArchUserPo archUserPo = (ArchUserPo) SecurityUtils.getSubject().getPrincipal() ;
        if (archBridgePo.getId() == null) {
            archBridgePo.setCreateTime(new Date());
            archBridgePo.setCreateUserId(archUserPo.getId());
            archBridgePo.setCreateUserName(archUserPo.getName());
        }
        archBridgePo.setUpdateUserId(archUserPo.getId());
        archBridgePo.setUpdateUserName(archUserPo.getName());
        archBridgeRepo.save(archBridgePo) ;
        return HttpResponse.SUCCESS("保存成功");
    }

    public HttpResponse<String> delete (int id) {
        archBridgeRepo.deleteById(id);
        return HttpResponse.SUCCESS("删除成功") ;
    }


}
