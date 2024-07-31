package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	SecurityConfig(){
		System.out.println("==>SecurityConfig");
	}
	
	@Autowired
	SecurityUserDetailsService	securityUserDetail;
	
	@Bean
	SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		// hasRole : 하나의 역할을 지정할때.
		// hasAnyRole : hasAnyRole("MANAGER", "ADMIN") - 여러 역할을 지정할때.
	    http.authorizeHttpRequests(authorize -> authorize
	              .requestMatchers("/board/getBoardList").authenticated()
	              .requestMatchers("/exam/**").hasRole("ADMIN")
	              .requestMatchers("/Port/**").hasAnyRole("MANAGER", "ADMIN")	             
	              .anyRequest().permitAll())
				
		.csrf(csrf ->csrf.disable())	
	    
		.formLogin(login ->login.loginPage("/login/loginForm").defaultSuccessUrl("/login/loginSuccess", true))
		.exceptionHandling(handling ->handling.accessDeniedPage("/login/accessDenied"))
		.logout(logout ->logout.invalidateHttpSession(true).logoutSuccessUrl("/"))
		.userDetailsService(securityUserDetail);
		return http.build(); 
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();		
	}
}