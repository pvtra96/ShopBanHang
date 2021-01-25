package com.javaweb.trapham;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import com.javaweb.trapham.service.UserService;
import com.javaweb.trapham.service.UserServiceImpl;

@SpringBootApplication(scanBasePackages = "com.javaweb.trapham")
@EntityScan(basePackages = "com.javaweb.trapham")
public class TraphamApplication extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImpl userServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(TraphamApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().antMatchers("/user/**")
				.hasAnyRole("USER").antMatchers("/admin/**")
				.hasAnyRole("ADMIN").and().formLogin().loginPage("/login").defaultSuccessUrl("/member/",true)
				.failureUrl("/login?e=error").permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/login?e=deny");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/user/css/**", "/user/assets/**", "/user/demos/**", "/user/examples/**", "/user/favicon/**", "/user/fonts/**", "/user/images/**","/user/img/**" , "/user/js/**","/user/music/**","/user/product/**" ,"/user/rs-plugin/**"  , "/user/watermark/**" , "/user/style.css","/admin/css/**", "/admin/assets/**", "/admin/images/**", "/admin/js/**", "/img/**");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		SpringSecurityDialect dialect = new SpringSecurityDialect();
		return dialect;
	}
}
