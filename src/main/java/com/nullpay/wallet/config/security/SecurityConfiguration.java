package com.nullpay.wallet.config.security;


import com.nullpay.wallet.auth.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;

    public SecurityConfiguration(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtService jwtService, UserDetailsServiceImpl userDetailsServiceImpl) throws Exception {
        System.out.println("*************** A Request Came trying to validate");
        System.out.println("URL: " + http.toString());
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize ->
             authorize
            .requestMatchers("/api/v1/auth/signup", "/api/v1/auth/login").permitAll()
            .requestMatchers("/api/**").authenticated()
                     .anyRequest().permitAll()
            )
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(new AuthenticationFilter(jwtService, userDetailsServiceImpl), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
