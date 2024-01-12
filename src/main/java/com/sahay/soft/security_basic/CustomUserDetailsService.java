package com.sahay.soft.security_basic;

import com.sahay.soft.entity.Role;
import com.sahay.soft.entity.User;
import com.sahay.soft.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByuserName(username).orElseThrow(() -> new RuntimeException("User Not Found!"));
        Set<Role> roles = user.getRoles();
        Set<SimpleGrantedAuthority> authorities = roles.stream().map(r->new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),authorities);
    }
}
