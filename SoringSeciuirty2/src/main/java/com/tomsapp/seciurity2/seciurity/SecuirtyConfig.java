package com.tomsapp.seciurity2.seciurity;

import com.tomsapp.seciurity2.entity.AppUser;
import com.tomsapp.seciurity2.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.accept.ContentNegotiationStrategy;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Configuration
public class SecuirtyConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
AppUserServiceImp appUserServiceImp;

    @Autowired
    AppUserRepository appUserRepository;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserServiceImp);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/image_upload").hasRole("ADMIN").
                antMatchers("/image_show").hasRole("USER").
                and().
                formLogin().
                permitAll().and().
                logout().permitAll();
    }

    @Bean
  public   PasswordEncoder passwordEncoder(){

        return new  BCryptPasswordEncoder();
    }


    @PostConstruct
    void CreateUser(){
        AppUser JanUser = new AppUser("admin", passwordEncoder().encode("12345"), "ROLE_ADMIN");
        AppUser BanUser = new AppUser("user", passwordEncoder().encode("12345"), "ROLE_USER");

        appUserRepository.save(JanUser);
        appUserRepository.save(BanUser);

    }


}
