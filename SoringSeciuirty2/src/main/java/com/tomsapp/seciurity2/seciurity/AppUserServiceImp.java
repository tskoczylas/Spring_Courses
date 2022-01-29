package com.tomsapp.seciurity2.seciurity;

import com.tomsapp.seciurity2.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AppUserServiceImp implements UserDetailsService {


    AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImp(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return appUserRepository.findAppUserByUsername(s);
    }
}
