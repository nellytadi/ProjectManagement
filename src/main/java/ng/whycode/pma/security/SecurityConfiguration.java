package ng.whycode.pma.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	@Autowired 
	BCryptPasswordEncoder bCryptEncoder;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
		.usersByUsernameQuery("SELECT username,password,enabled FROM user_accounts WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT username,role FROM user_accounts WHERE username = ?")
		.dataSource(dataSource)
		.passwordEncoder(bCryptEncoder);
		
		
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.withDefaultSchema()
//		.withUser("root")
//			.password("123456")
//			.roles("USER")
//		.and()
//		.withUser("test")
//			.password("123456")
//			.roles("USER")
//		.and()
//		.withUser("admin")
//			.password("123456")
//			.roles("ADMIN");
		
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/project/create").hasRole("ADMIN")
			.antMatchers("/project/store").hasRole("ADMIN")
			.antMatchers("/employee/create").hasRole("ADMIN")
			.antMatchers("/employee/store").hasRole("ADMIN")
			.antMatchers("/","/**").permitAll()
			.and()
			.formLogin();
	//.formLogout()
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

}
