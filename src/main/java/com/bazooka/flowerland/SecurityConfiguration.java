package com.bazooka.flowerland;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/", "/index**", "/login**", "/h2-console/**").permitAll()
                // prideti URL'us kuriuos gali matyt visi
        .and()
        .authorizeRequests()
        .antMatchers("/test**").hasRole("ADMIN") // URL, kuriuos mato tik admin
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .and()
        .httpBasic();

        http.csrf().ignoringAntMatchers("/h2-console/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}pass") // Spring Security 5 requires specifying the password storage format
                .roles("ADMIN");
    }

}
