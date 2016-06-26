package in.spring4buddies.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password")
				.roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("password")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("password")
				.roles("ADMIN", "DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/home")
				.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
				.and()
					.formLogin().loginPage("/login")
					.usernameParameter("ssoId").passwordParameter("password")
				.and()
					.exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}
