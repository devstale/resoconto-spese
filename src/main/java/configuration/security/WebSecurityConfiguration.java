package configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@ComponentScan("configuration.security")
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  };
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    	.authorizeRequests()
    	.antMatchers("/resources/**").permitAll()
    	.anyRequest().fullyAuthenticated()
    .and()
    	.authorizeRequests().antMatchers("/").permitAll()
    .and()
    	.formLogin()
    		.loginPage("/")
    		.loginProcessingUrl("/loginAction")
    		.successHandler( new CustomAuthenticationSuccessHandler() )
    		.permitAll()
    .and()
    	.logout().logoutSuccessUrl("/").permitAll()
    .and()
    	.csrf().disable();
  }
}