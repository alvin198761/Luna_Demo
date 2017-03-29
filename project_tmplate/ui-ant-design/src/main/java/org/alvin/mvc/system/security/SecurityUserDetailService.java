package org.alvin.mvc.system.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by tangzhichao on 2016/8/18.
 */
@Component
public class SecurityUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // UserInfo userInfo = this.userService.findUserByName(username);
        // Assert.notNull(userInfo);
        // GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole().name());
        //  return new User(userInfo.getName(), userInfo.getPassword(),true,true, true, true, Collections.singletonList(authority));
        return new ScopeUser(null, null, null);
    }
}
