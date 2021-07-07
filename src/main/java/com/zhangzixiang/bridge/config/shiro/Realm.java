package com.zhangzixiang.bridge.config.shiro;

import com.zhangzixiang.bridge.entity.ArchUserPo;
import com.zhangzixiang.bridge.repo.ArchUserRepo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class Realm extends AuthorizingRealm  {

    @Resource
    private ArchUserRepo archUserRepo ;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        /** principals 是区分登录权限的 */
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        return  info ;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal() ;
        /** 获取用户名 */
        ArchUserPo user = archUserRepo.findByName(username) ;
        String password = user.getPassword() ;
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo (
                user, password, getName()
                /** 这里第一个参数只是为了放一个值进去，第二个参数password才是为了校验密码 */
                /** getName()是一个固定的方法，这么写就行了 */
                /** 这里只需要把数据库里的密码放在这里和前端传来的密码校验即可 */
                /** 前端传来的密码不会在这里显示，为了安全会在token里面存放 */
        ) ;
        return info;
    }
}
