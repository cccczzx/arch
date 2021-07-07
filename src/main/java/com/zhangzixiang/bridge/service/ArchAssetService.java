package com.zhangzixiang.bridge.service;

import com.zhangzixiang.bridge.entity.ArchAssetPo;
import com.zhangzixiang.bridge.entity.ArchUserPo;
import com.zhangzixiang.bridge.model.ArchAssetInVo;
import com.zhangzixiang.bridge.repo.ArchAssetRepo;
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
public class ArchAssetService {

    @Resource
    private ArchAssetRepo archAssetRepo ;

    public HttpResponse<List<ArchAssetPo>> findArchAssetPoList (Integer sectionId) {
        List<ArchAssetPo> archAssetPoList ;
        archAssetPoList = archAssetRepo.findBySectionId(sectionId) ;
        return HttpResponse.SUCCESS(archAssetPoList) ;
    }

    public HttpResponse<Page<ArchAssetPo>> findArchAssetPoPage (String bridgeName, String sectionName, int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime") ;
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, sort) ;
        Page<ArchAssetPo>  archAssetPos = archAssetRepo.findAll((Specification<ArchAssetPo>) (root, criteriaQuery,criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction() ;
            if (!StringUtils.isEmpty(bridgeName)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("bridgeName"), "%"+bridgeName+"%"));
            }
            if (!StringUtils.isEmpty(sectionName)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("sectionName"), "%"+sectionName+"%"));
            }
            return predicate ;
        }, pageRequest) ;
        return HttpResponse.SUCCESS(archAssetPos) ;
    }

    public HttpResponse<String> save (ArchAssetInVo archAssetInVo) {
        ArchAssetPo archAssetPo = new ArchAssetPo() ;
        BeanUtils.copyProperties(archAssetInVo, archAssetPo);
        ArchUserPo archUserPo = (ArchUserPo) SecurityUtils.getSubject().getPrincipal() ;
        if (archAssetPo.getId()==null) {
            archAssetPo.setCreateTime(new Date());
            archAssetPo.setCreateUserId(archUserPo.getId());
            archAssetPo.setCreateUserName(archUserPo.getName());
        }
        archAssetPo.setUpdateUserId(archUserPo.getId());
        archAssetPo.setUpdateUserName(archUserPo.getName());
        archAssetRepo.save(archAssetPo) ;
        return HttpResponse.SUCCESS("保存成功") ;
    }

    public HttpResponse<String> delete (int id) {
        archAssetRepo.deleteById(id);
        return HttpResponse.SUCCESS("删除成功") ;
    }

}
