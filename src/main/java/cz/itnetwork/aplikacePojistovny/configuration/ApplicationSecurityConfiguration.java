package cz.itnetwork.aplikacePojistovny.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)

public class ApplicationSecurityConfiguration {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http
                    .authorizeHttpRequests()
                        .anyRequest()
                            .permitAll()
                        .and()
                    .formLogin() // Pokud uživatel není přihlášen, přesměrujeme ho na login formulář
                        .loginPage("/account/login") // Přihlašovací URL adresa
                        .loginProcessingUrl("/account/login") // Přihlašovací URL adresa
                        .defaultSuccessUrl("/clientes", true) // Nastavení přesměrování po úspěšném přihlášení
                        .usernameParameter("email") // Chceme se přihlašovat pomocí emailu
                        .permitAll() // Povolit vstup na `/account/login` i nepřihlášeným uživatelům
                        .and()
                    .logout()
                        .logoutUrl("/account/logout") // Odhlašovací URL adresa
                        .and()
                    .build();

        }
        @Bean
        public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
