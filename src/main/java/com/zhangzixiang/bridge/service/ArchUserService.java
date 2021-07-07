package com.zhangzixiang.bridge.service;

import com.zhangzixiang.bridge.entity.ArchUserPo;
import com.zhangzixiang.bridge.model.ArchUserInVo;
import com.zhangzixiang.bridge.repo.ArchUserRepo;
import com.zhangzixiang.bridge.util.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;

@Service
public class ArchUserService {

    @Resource
    private ArchUserRepo archUserRepo ;

    public HttpResponse<Page<ArchUserPo>> findArchUserPage (String phone, int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime") ;
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, sort) ;
        Page<ArchUserPo> archUserPos = archUserRepo.findAll((Specification<ArchUserPo>) (root, criteriaQuery, criteriaBuilder) ->{
            Predicate predicate = criteriaBuilder.conjunction() ;
            if (!StringUtils.isEmpty(phone)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("phone"), "%"+phone+"%"));
            }
            return predicate ;
        }, pageRequest) ;
        return HttpResponse.SUCCESS(archUserPos) ;
    }

    public HttpResponse<ArchUserPo> saveUser(ArchUserInVo archUserInVo) {
        ArchUserPo archUserPo = new ArchUserPo() ;
        BeanUtils.copyProperties(archUserInVo, archUserPo);
        archUserPo.setPassword("123456");
        archUserRepo.save(archUserPo) ;
        return HttpResponse.SUCCESS(archUserPo) ;
    }

    public HttpResponse<String> deleteUser(int id) {
        ArchUserPo archUserPo = archUserRepo.findById(id).orElse(null) ;
        if (archUserPo == null) {
            return HttpResponse.FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(),"删除失败，未查询到该用户");
        }
        archUserRepo.delete(archUserPo);
        return HttpResponse.SUCCESS("删除成功");
    }

}
