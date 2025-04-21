package com.example.learnical.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity

class SecurityConfig {

    @Profile("!dev")
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/public/**").permitAll()
                    .anyRequest().authenticated()
            }
            .oauth2ResourceServer { oauth2 ->
                oauth2.jwt {}

            }

        return http.build()
    }

    @Profile("dev")
    @Bean
    fun securityFilterChainDev(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { auth ->
            auth.anyRequest().permitAll()
        }.csrf {
            it.disable()
        }

        return http.build()
    }
}
