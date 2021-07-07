package com.zhangzixiang.bridge.service;

import com.zhangzixiang.bridge.entity.ArchAssetTypePo;
import com.zhangzixiang.bridge.entity.ArchUserPo;
import com.zhangzixiang.bridge.model.ArchAssetTypeInVo;
import com.zhangzixiang.bridge.repo.ArchAssetTypeRepo;
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
public class ArchAssetTypeService {

    @Resource
    private ArchAssetTypeRepo archAssetTypeRepo ;

    public HttpResponse<List<ArchAssetTypePo>> findArchAssetTypeList(String bridgeName) {
        List<ArchAssetTypePo> archAssetTypePoList ;
        archAssetTypePoList = archAssetTypeRepo.findByBridgeName(bridgeName) ;
        return HttpResponse.SUCCESS(archAssetTypePoList) ;
    }

    public HttpResponse<Page<ArchAssetTypePo>> findArchAssetTypePage(String typeName, int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime") ;
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, sort) ;
        Page<ArchAssetTypePo> archAssetTypePos = archAssetTypeRepo.findAll((Specification<ArchAssetTypePo>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction() ;
            if (!StringUtils.isEmpty(typeName)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("typeName"), "%"+typeName+"%"));
            }
            return predicate ;
        }, pageRequest) ;
        return HttpResponse.SUCCESS(archAssetTypePos) ;
    }

    public HttpResponse<String> save(ArchAssetTypeInVo archAssetTypeInVo) {
        ArchAssetTypePo archAssetTypePo = new ArchAssetTypePo() ;
        BeanUtils.copyProperties(archAssetTypeInVo, archAssetTypePo);
        ArchUserPo archUserPo = (ArchUserPo) SecurityUtils.getSubject().getPrincipal() ;
        if (archAssetTypePo.getId() == null) {
            archAssetTypePo.setCreateTime(new Date());
            archAssetTypePo.setCreateUserId(archUserPo.getId());
            archAssetTypePo.setCreateUserName(archUserPo.getName());
        }
        archAssetTypePo.setUpdateUserId(archUserPo.getId());
        archAssetTypePo.setUpdateUserName(archUserPo.getName());
        archAssetTypeRepo.save(archAssetTypePo) ;
        return HttpResponse.SUCCESS("保存成功");
    }

    public HttpResponse<String> delete(int id) {
        archAssetTypeRepo.deleteById(id);
        return HttpResponse.SUCCESS("删除成功");
    }


}
