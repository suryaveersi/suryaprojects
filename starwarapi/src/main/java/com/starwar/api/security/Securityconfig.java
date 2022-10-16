package com.starwar.api.security;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.starwar.api.service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationEntryPoint authentrypoint;
	@Autowired
	CustomUserDetailService customuserdetailservice;
	
	@Autowired
     JwtTokenFilter jwtTokenFilter;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * http.csrf().and().
		 * authorizeRequests().antMatchers("/user/**").hasRole("ADMIN").
		 * antMatchers("/starwar/**").hasRole("NORMAL").
		 * anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(
		 * authentrypoint);
		 */
		
	    http.csrf().disable().
		authorizeRequests().antMatchers("/authenticatetoken").permitAll().and().
				authorizeRequests().antMatchers("/h2-console/**")
				.permitAll().anyRequest().authenticated();
		http.headers().frameOptions().disable();
		
		
	     http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
	     //not to use session management since we are using stateless behaviour
		 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
		
		}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// for in memory authentication
		//auth.inMemoryAuthentication().withUser("suryaveer").password(this.PasswordEncoder().encode("12345")).roles("NORMAL");
		//auth.inMemoryAuthentication().withUser("singh").password(this.PasswordEncoder().encode("123456")).roles("ADMIN");
		
		//Jwt authentication
		auth.userDetailsService(customuserdetailservice);
		
		}
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
		
	}
	
	@Bean
	protected  BCryptPasswordEncoder PasswordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();

	}

	@Bean
	ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/h2-console/*");
		return registrationBean;
	}

	
	
}
