package com.example.loginsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                // Permitir acceso sin autenticación a recursos estáticos y páginas públicas
                .requestMatchers("/registro/**", "/js/**", "/css/**", "/images/**").permitAll()
                .requestMatchers("/login").permitAll()

                // Rutas específicas por roles
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/formulario-cliente/**").hasRole("CLIENTE")
                .requestMatchers("/empleado/**").hasRole("EMPLEADO")
                // .requestMatchers("/almacen/**").hasRole("ALMACEN")
                

                // Cualquier otra solicitud requiere autenticación
                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/default") // Redirige según el rol
                        .permitAll())
                .logout(logout -> logout
                        .permitAll());

        return http.build();
    }
}
