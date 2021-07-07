package com.zhangzixiang.bridge.service;

import com.zhangzixiang.bridge.dao.ArchSectionMapper;
import com.zhangzixiang.bridge.entity.ArchSectionPo;
import com.zhangzixiang.bridge.entity.ArchUserPo;
import com.zhangzixiang.bridge.model.ArchSectionInVo;
import com.zhangzixiang.bridge.model.ArchSectionOutVo;
import com.zhangzixiang.bridge.repo.ArchSectionRepo;
import com.zhangzixiang.bridge.util.HttpResponse;
import org.springframework.beans.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
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
public class ArchSectionService {

    @Resource
    private ArchSectionRepo archSectionRepo ;

    @Resource
    private ArchSectionMapper archSectionMapper ;

    public HttpResponse<List<ArchSectionOutVo>> findArchSectionList(Integer typeId) {

        List<ArchSectionOutVo> archSectionOutVoList = archSectionMapper.findArchSectionList(typeId) ;
        return HttpResponse.SUCCESS(archSectionOutVoList) ;

    }

    public HttpResponse<Page<ArchSectionPo>> findArchSectionPage(String bridgeName, int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime") ;
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, sort) ;
        Page<ArchSectionPo> archSectionPos = archSectionRepo.findAll((Specification<ArchSectionPo>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction() ;
            if (!StringUtils.isEmpty(bridgeName)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("bridgeName"), "%"+bridgeName+"%"));
            }
            return predicate ;
        }, pageRequest) ;
        return HttpResponse.SUCCESS(archSectionPos) ;
    }

    public HttpResponse<String> save(ArchSectionInVo archSectionInVo) {
        ArchSectionPo archSectionPo = new ArchSectionPo() ;
        BeanUtils.copyProperties(archSectionInVo, archSectionPo);
        ArchUserPo archUserPo = (ArchUserPo) SecurityUtils.getSubject().getPrincipal() ;
        if (archSectionPo.getId() == null){
            archSectionPo.setCreateTime(new Date());
            archSectionPo.setCreateUserId(archUserPo.getId());
            archSectionPo.setCreateUserName(archUserPo.getName());
        }
        archSectionPo.setUpdateUserId(archUserPo.getId());
        archSectionPo.setUpdateUserName(archUserPo.getName());
        archSectionRepo.save(archSectionPo) ;
        return HttpResponse.SUCCESS("保存成功");
    }

    public HttpResponse<String> delete (int id) {
        archSectionRepo.deleteById(id);
        return HttpResponse.SUCCESS("删除成功");
    }


}
