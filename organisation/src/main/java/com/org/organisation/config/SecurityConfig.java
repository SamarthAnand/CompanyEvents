package com.org.organisation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.org.organisation.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailService(PasswordEncoder passwd) {
		UserDetails admin = User.withUsername("admin")
				.password(passwd.encode("1qaz"))
				.roles("ADMIN")
				.build();
		UserDetails user = User.withUsername("samarth")
				.password(passwd.encode("qwerty"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin, user );
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf().disable()
		
		.authorizeHttpRequests().requestMatchers("/api/**")
		
		.permitAll()	
		.and()
		
		.build();	
		
	}
}
