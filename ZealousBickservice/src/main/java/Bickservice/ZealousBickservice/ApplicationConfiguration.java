package Bickservice.ZealousBickservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class ApplicationConfiguration
{

	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager uservalues()
	{
		UserDetails user1=User.withUsername("ganesh")
				.password(encoder().encode("ganesh123"))
				.roles("USER").build();
		UserDetails user2=User.withUsername("sankar")
				.password(encoder().encode("sankar123"))
				.roles("USER").build();

		return new InMemoryUserDetailsManager(user1,user2);
	}

	@Bean
	public SecurityFilterChain safety(HttpSecurity hp) throws Exception
	{
		hp
		.authorizeRequests()
		.antMatchers("/mybikeproject")
		.authenticated();
		hp.csrf().disable();
		hp.formLogin();
		hp.httpBasic();

		return hp.build();
	}	

	
}



