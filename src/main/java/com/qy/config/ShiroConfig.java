package com.qy.config;

import com.qy.realm.UserRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public CredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        credentialsMatcher.setHashIterations(1010);
        return credentialsMatcher;
    }

    @Bean
    public UserRealm userRealm(CredentialsMatcher credentialsMatcher){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    @Bean
    public SessionsSecurityManager securityManager(UserRealm userRealm){
        SessionsSecurityManager sessionsSecurityManager = new DefaultWebSecurityManager();
        sessionsSecurityManager.setRealm(userRealm);
        return sessionsSecurityManager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition shiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/pages/login.jsp","anon");
        filterChainMap.put("/pages/**","authc");
        filterChainMap.put("/logout.do","logout");
        shiroFilterChainDefinition.addPathDefinitions(filterChainMap);
        return shiroFilterChainDefinition;
    }

}
