package com.malin.demo.shrio;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.malin.demo.model.User;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class UserRealm extends AuthorizingRealm {

	/***
	 * 提供用户信息返回授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/***
	 * 提供用户信息返回认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		log.info("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");
		
	User user=(User)token;
	System.out.println(user.getNickname());
	System.err.println(user.getPswd());
	
		return null;
	}

}
