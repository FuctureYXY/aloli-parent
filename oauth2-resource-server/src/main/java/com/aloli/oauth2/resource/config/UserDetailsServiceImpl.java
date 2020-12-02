package com.aloli.oauth2.resource.config;



import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: yangyongcui
 * @Date: 2020/7/13: 10:10
 * @Description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List list = new ArrayList();
        /*SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("LEADER");
        SimpleGrantedAuthority simpleGrantedAuthority2 = new SimpleGrantedAuthority("web");
        list.add(simpleGrantedAuthority);
        list.add(simpleGrantedAuthority2);*/
        return new User("aa", new BCryptPasswordEncoder().encode("bb"), list);
    }
}
