package com.practice.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/**").authenticated().antMatchers("/").permitAll()
		.and().oauth2Login()
		.defaultSuccessUrl("/");
	}
}
