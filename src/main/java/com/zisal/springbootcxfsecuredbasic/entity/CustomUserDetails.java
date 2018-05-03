package com.zisal.springbootcxfsecuredbasic.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created on 5/2/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CustomUserDetails extends User implements UserDetails {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3727198706022925008L;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        getRoles().stream().forEach(System.out::println);
        return getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public CustomUserDetails() {
    }

    public CustomUserDetails(User p_User) {
        super(p_User.getCode(), p_User.getName(), p_User.getPassword(), p_User.getEnabled(), p_User.getRoles());
    }

    @Override
    public String getUsername() {
        return super.getCode();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.getEnabled() == 1;
    }
}
