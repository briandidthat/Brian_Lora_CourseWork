package com.trilogyed.gamestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?")
                .passwordEncoder(encoder);
    }

    public void configure(HttpSecurity httpSecurity) throws Exception {
        // Any user (both authenticated and unauthenticated) can search for products.
        // Any staff member can update a product.
        // Only Managers and above can create new products.
        // Only Admin users can delete a product.
        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                // Console Routes
                .mvcMatchers(HttpMethod.POST, "/gamestore/consoles").hasAnyAuthority("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/gamestore/consoles/*").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.PUT, "/gamestore/consoles/*").hasAnyAuthority("MANAGER", "ADMIN")
                // Game Routes
                .mvcMatchers(HttpMethod.POST, "/gamestore/games").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/gamestore/games/*").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.PUT, "/gamestore/games/*").hasAnyAuthority( "ADMIN", "MANAGER")
                // Invoice Routes
                .mvcMatchers(HttpMethod.POST, "/gamestore/invoices").hasAnyAuthority("USER", "ADMIN", "MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/gamestore/invoices/*").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.PUT, "/gamestore/invoices/*").hasAnyAuthority("ADMIN","MANAGER")
                // T-Shirt Routes
                .mvcMatchers(HttpMethod.POST, "/gamestore/tshirts").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/gamestore/tshirts/*").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.PUT, "/gamestore/tshirts/*").hasAnyAuthority( "ADMIN","MANAGER")
                .anyRequest().permitAll();

        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }
}
