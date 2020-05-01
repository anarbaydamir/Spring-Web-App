package com.company.service;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Service("customUserDetail")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        UserBuilder userBuilder = null;

        if (user!=null){
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);

            userBuilder.disabled(false);
            userBuilder.password(user.getPassword());

            String[] authoritiesArr = new String[]{"USER","ADMIN","ROLE_USER"};
            userBuilder.authorities(authoritiesArr);

            return userBuilder.build();
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }

}
