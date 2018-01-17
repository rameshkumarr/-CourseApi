package io.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.inMemoryAuthentication()
         .withUser("aba").password("aba").roles("USER").and()
         .withUser("admin").password("admin").roles("USER", "ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

      http
        .httpBasic().and()
        .authorizeRequests()
          .antMatchers(HttpMethod.POST, "/topics").hasRole("ADMIN")
          .antMatchers(HttpMethod.PUT, "/topics{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.DELETE, "/topics{id}").hasRole("ADMIN").and()
        .csrf().disable();
    }
}