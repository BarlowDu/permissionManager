package com.barlow.permission.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;

import java.util.Collection;

/**
 * Created by dutc on 2017/3/16.
 */
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo result=new SimpleAuthorizationInfo();
        result.setRoles(CollectionUtils.asSet("admin"));
        result.setStringPermissions(CollectionUtils.asSet("user:*","resource:*"));
        return result;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();

        //User user = userService.findByUsername(username);

        /*if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                "admin", //用户名
                "13b99ae06765b31ec9b09beae190e7ff", //密码
                ByteSource.Util.bytes("8d78869f470951332959580424d4bf4f"),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
