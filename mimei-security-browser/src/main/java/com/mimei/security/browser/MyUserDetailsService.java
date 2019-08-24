package com.mimei.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author wuchongliang
 * @create 2019-08-24 14:57:16
 * @description:  实现UserDetailsService接口，获取用户信息
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 根据用户名查询用户信息，将查询结果封装到UserDetails中
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户的登录名：{}", username);
        // 根据用户名查询用户信息
        return new User(username, passwordEncoder.encode("123456"), true,
                true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
