package com.malin.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.malin.demo.shrio.UserRealm;

@Configuration
public class ShrioConfig {
	/**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     *
     */
	//@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean =new ShiroFilterFactoryBean();
		
		//配置Shiro过滤器
        /**
         * 内置Shiro过滤器实现相关拦截功能
         *      常用的过滤器有：
         *          anon  : 无需认证（登录）可以访问
         *          authc : 必须认证才能访问
         *          user  : 如果使用rememberMe的功能可以直接访问
         *          perms : 该资源必须得到资源访问权限才可以使用
         *          role  : 该资源必须得到角色授权才可以使用
         */
	     // 必须设置 SecurityManager
		factoryBean.setSecurityManager(securityManager);
		 // 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
		factoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		factoryBean.setSuccessUrl("/index");
		//未授权的页面
		factoryBean.setUnauthorizedUrl("/403");
		 // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        
        filterChainDefinitionMap.put("/swagger-*/**", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html/**", "anon");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");

        filterChainDefinitionMap.put("/add", "perms[权限添加]");
     // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");

        
     // 以“/user/admin” 开头的用户需要身份认证，authc 表示要进行身份认证
  //      filterChainDefinitionMap.put("/user/admin*", "authc");
        // “/user/student” 开头的用户需要角色认证，是“admin”才允许
      //  filterChainDefinitionMap.put("/user/student*/**", "roles[admin]");
        // “/user/teacher” 开头的用户需要权限认证，是“user:create”才允许
      //  filterChainDefinitionMap.put("/user/teacher*/**", "perms[\"user:create\"]");

        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return factoryBean;
	}
	
	@Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myUserRealn());
        return securityManager;
    }
	/**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     * 
     * @return
     */
	@Bean
	public  UserRealm myUserRealn () {
		UserRealm userRealm =new UserRealm();
		
		return userRealm;
		
	}
	
	
	
	

}
