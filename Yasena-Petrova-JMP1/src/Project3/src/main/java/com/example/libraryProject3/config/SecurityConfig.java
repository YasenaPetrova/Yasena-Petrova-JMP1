package com.example.libraryProject3.config;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig   {
    private final UserDetailsService userDetailsService;
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/library/user/register").not().authenticated()
                                .requestMatchers("/api/library/book/all").permitAll()
                                .requestMatchers("/api/library/book/search").permitAll()
                                .requestMatchers("/api/library/book/{id}").permitAll()
                                .requestMatchers("/api/library/book/rate").hasRole("READER")
                                .requestMatchers("/api/library/book/add-to-library").hasRole("READER")
                                .requestMatchers("/api/library/book").hasRole("AUTHOR")
                                .requestMatchers("/api/library/user/lock/{userId}").hasRole("ADMIN")
                                .requestMatchers("/api/library/user/unlock/{userId}").hasRole("ADMIN")
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
