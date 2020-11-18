package com.jpa.a.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()

		.anyRequest().permitAll()
		.and()
		.formLogin()
		
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		
		.deleteCookies("JSESSIONID")
		.permitAll();
		http.sessionManagement()
	    .invalidSessionUrl("/")
	    .maximumSessions(1)
	    .maxSessionsPreventsLogin(true)
	    .expiredUrl("/")
	    .sessionRegistry(sessionRegistry()); // 동시 로그인 불가	
	}
	
	@Override
	 public void configure(WebSecurity webSecurity) throws Exception {
		 
	  webSecurity.ignoring().antMatchers("/static/**", "/css/**", "/fonts/**", "/js/**", "/less/**", "/scss/**", "/images/**", "/webjars/**"); 
	 }
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean 
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() { 
		
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher()); 
		
		}

	
	@Bean
	public SessionRegistry sessionRegistry() {
		
		return new SessionRegistryImpl(); 
	}
	
	

}
