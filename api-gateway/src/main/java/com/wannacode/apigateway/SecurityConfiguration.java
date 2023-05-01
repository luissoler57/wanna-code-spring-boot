package com.wannacode.apigateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    /**
     * This function configures security settings for a web filter chain in a Java
     * application,
     * allowing any authenticated user to access any endpoint and disabling CSRF
     * protection.
     * 
     * @param httpSecurity An instance of ServerHttpSecurity, which is used to
     *                     configure security for a
     *                     web server that uses Spring Security.
     * @return The method is returning a `SecurityWebFilterChain` object.
     */
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity.authorizeExchange(exchange -> exchange.anyExchange().authenticated())
                .oauth2Login(Customizer.withDefaults());
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
