package pl.dofizjo.dofizjoapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configuring access
        http
                .authorizeRequests()
                    .antMatchers( "/cms", "/cms/edit", "cms/blog") // Needs to be specifically mentioned to disallow /orders/current to disallow it...
                        .access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/", "/h2-console/**")
                        .access("permitAll")
                    .and() // specifying login page (if we want to change the default login bland page)
                        .formLogin()
                        .loginPage("/login")
                    .and()
                        .logout()
                        .logoutSuccessUrl("/"); // redirecting on logout

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
