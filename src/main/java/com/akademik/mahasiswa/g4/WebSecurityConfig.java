package com.akademik.mahasiswa.g4;

import com.akademik.mahasiswa.g4.utls.UserUtils;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Predicate;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .antMatchers("/admin/**").hasRole("SEKRETARIAT")
                .antMatchers("/irs/**").hasRole("MAHASISWA")
                .antMatchers("/mahasiswa/**").hasAnyRole("SEKRETARIAT","MAHASISWA")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler((req, res, auth) -> {
                    boolean isMahasiswa = auth.getAuthorities().stream()
                            .anyMatch((Predicate<GrantedAuthority>) grantedAuthority -> grantedAuthority.getAuthority()
                                    .equals(UserUtils.ROLE_MAHASISWA));
                    if(isMahasiswa){
                        res.sendRedirect("/mahasiswa/ringkasan");
                    }else{
                        res.sendRedirect("/admin");
                    }
                })
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll();
    }

    /*
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("user").password("password").roles("MAHASISWA");

		auth.inMemoryAuthentication()
		.withUser("admin").password("admin").roles("SEKRETARIAT");
	}*/

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from user where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_role where username=?");
    }
}