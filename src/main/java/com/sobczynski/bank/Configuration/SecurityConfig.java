package com.sobczynski.bank.Configuration;

import com.sobczynski.bank.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Service service;

    @Autowired
    public SecurityConfig(Service service) {
        this.service = service;
    }


    //todo Trzeba to jakoś zautomatyzować
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user_0 = User.withDefaultPasswordEncoder()
                .username(service.getAccountById(0).getLogin())
                .password(service.getAccountById(0).getPassword())
                .roles("USER_0")
                .build();
        UserDetails user_1 = User.withDefaultPasswordEncoder()
                .username(service.getAccountById(1).getLogin())
                .password(service.getAccountById(1).getPassword())
                .roles("USER_1")
                .build();
        UserDetails user_2 = User.withDefaultPasswordEncoder()
                .username(service.getAccountById(2).getLogin())
                .password(service.getAccountById(2).getPassword())
                .roles("USER_2")
                .build();
        UserDetails user_3 = User.withDefaultPasswordEncoder()
                .username(service.getAccountById(3).getLogin())
                .password(service.getAccountById(3).getPassword())
                .roles("USER_3")
                .build();
        return new InMemoryUserDetailsManager(user_0, user_1, user_2, user_3);
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/accounts/0").hasRole("USER_0")
                .antMatchers("/accounts/1").hasRole("USER_1")
                .antMatchers("/accounts/2").hasRole("USER_2")
                .antMatchers("/accounts/3").hasRole("USER_3")
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout().
                permitAll();
    }
}
