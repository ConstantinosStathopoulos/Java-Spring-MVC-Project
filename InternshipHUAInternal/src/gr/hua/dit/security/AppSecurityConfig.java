package gr.hua.dit.security;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	DataSource dataSource;
	
	
	//@Overide
	@Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
		 auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("select username,password, enabled from users.data where username=?")
		.authoritiesByUsernameQuery("select username, authority from users.authorities where username=?");
            
           
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Configuration
    @Order(1)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
                  http.csrf().disable()
              .antMatcher("/api/**")
              .authorizeRequests()
                  .anyRequest().authenticated()
                  .and()
              .httpBasic();
        }
    }
	
	
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/CareerOffice/*").hasRole("OFFICE")
	 * .antMatchers("/Student/*").hasRole("STUDENT") .and() .formLogin()
	 * .loginPage("/login") .loginProcessingUrl("/login")
	 * .successHandler(myAuthenticationSuccessHandler())
	 * .loginProcessingUrl("/authUser").permitAll().and().logout().permitAll();
	 * 
	 * }
	 */
	 
//	import org.apache.commons.logging.Log;
	
	@Bean
    public static AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new UrlAuthenticationSuccessHandler();
    }
	

	
	@Configuration
    @Order(2)
    public static class FormWebSecurityConfig extends WebSecurityConfigurerAdapter{

        @Override
        public void configure(WebSecurity web) throws Exception {
                    web.ignoring().antMatchers("/resources/**");
        }

        @Override protected void configure(HttpSecurity http) throws Exception {
      	  http.authorizeRequests() .antMatchers("/CareerOffice/*").hasRole("OFFICE")
      	  .antMatchers("/Student/*").hasRole("STUDENT") .and() .formLogin()
      	  .loginPage("/login") .loginProcessingUrl("/login")
      	  .successHandler(myAuthenticationSuccessHandler())
      	  .loginProcessingUrl("/authUser").permitAll().and().logout().permitAll();
      	  
      	  }
    }
	
	
	
	
	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/resources/**");
	 * 
	 * web.ignoring().antMatchers("/api/**"); }
	 */
	
	
	
	
	
	
	
}
