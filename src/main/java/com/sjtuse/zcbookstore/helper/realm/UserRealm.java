package com.sjtuse.zcbookstore.helper.realm;

import com.sjtuse.zcbookstore.entity.User;
import com.sjtuse.zcbookstore.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by zcoaolas on 3/19/2017.
 */
public class UserRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        if(username.equals("admin")){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("admin");
            return info;
        }
        else if(userService.getByUsername(username) != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("user");
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
        throws AuthenticationException{
        UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
        String username = uptoken.getUsername();
        User u = userService.getByUsername(username);
        if (u == null){
            throw new UnknownAccountException("User not exists");
        }

        Object principal = username;
        Object pwd = u.getPassword();
        String realmName = getName();
        ByteSource pwdSalt = ByteSource.Util.bytes(u.getUserId().toString());

        return new SimpleAuthenticationInfo(principal, pwd, pwdSalt, realmName);
    }
}
