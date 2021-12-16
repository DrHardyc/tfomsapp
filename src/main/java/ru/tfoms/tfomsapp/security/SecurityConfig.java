package ru.tfoms.tfomsapp.security;

import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.tfoms.tfomsapp.service.UserService;
import ru.tfoms.tfomsapp.view.LoginView;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {

    private static final String LOGIN_PROCESSING_URL = "/login";
    private static final String LOGIN_FAILURE_URL = "/login?error"; //
    private static final String LOGIN_URL = "/login";
    private static final String LOGOUT_SUCCESS_URL = "/login";

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        setLoginView(http, LoginView.class);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                    .csrf()
//                    .disable()
//                    .requestCache()
//                    .requestCache(new CustomRequestCache())
//                .and()
//                    .authorizeRequests()
//                    .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()
//                    .anyRequest()
//                    .authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage(LOGIN_URL).permitAll()
//                    .loginProcessingUrl(LOGIN_PROCESSING_URL)
//                    .failureUrl(LOGIN_FAILURE_URL)
//                .and()
//                    .logout()
//                    .logoutSuccessUrl(LOGOUT_SUCCESS_URL);
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
//        web.ignoring().antMatchers(
//                "/VAADIN/**",
//                "/favicon.ico",
//                "/robots.txt",
//                "/manifest.webmanifest",
//                "/sw.js",
//                "/offline-page.html",
//                "/frontend/**",
//                "/webjars/**",
//                "/frontend-es5/**", "/frontend-es6/**");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
}
