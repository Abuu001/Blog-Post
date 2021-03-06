package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
             http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/blogs/post/all","/api/v1/user/**")
                  .hasRole("USER")
                .antMatchers("/api/v1/blogs/post/all","/api/v1/user/**","/api/v1/blogs/post/","/api/v1/blogs/update/","/api/v1/blogs/remove/","/api/v1/blogs/find/")
                  .hasRole("ADMIN")
                .antMatchers("/login","/api/v1/blogs/post/all","/api/v1/user/**").permitAll()
                .anyRequest()
                .authenticated()
               /* .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
                .and()
                .httpBasic();
    }
}
