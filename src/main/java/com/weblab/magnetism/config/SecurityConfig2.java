//package com.weblab.magnetism.config;
//
//import com.weblab.magnetism.service.impl.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@EnableWebSecurity
//public class SecurityConfig2 extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    //authentication
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    //authorization
//    //SpringSecurity configuration
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/auth/login","/error").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/auth/login").loginProcessingUrl("/process-login")
//                .defaultSuccessUrl("/ui/user/list", true)
//                .failureUrl("/auth/login?error");
//    }
//
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
//
//
//
///*
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return new ShopmeUserDetailsService();
////    }
//
//
//
//
//    @Autowired
//    private AuthProviderImpl authProvider;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
////        http.authorizeRequests().antMatchers("/login").permitAll()
////                .antMatchers("/users/**", "/settings/**").hasAuthority("Admin")
////                .hasAnyAuthority("Admin", "Editor", "Salesperson")
////                .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
////                .anyRequest().authenticated()
////                .and().formLogin()
////                .loginPage("/login")
////                .usernameParameter("email")
////                .permitAll()
////                .and()
////                .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
////                .and()
////                .logout().permitAll();
//
////        http.authenticated();
//        http.authenticationProvider(authProvider);
////        http.headers().frameOptions().sameOrigin();
//
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//    }
//
//}
//
// */