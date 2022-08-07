package ro.fasttrack.tema12exerc1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfig
{
    @Bean
    SecurityFilterChain httpSecurityConfig(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeHttpRequests(
                authz -> authz.mvcMatchers("/students").hasAnyRole("ADMIN", "TEACHER", "STUDENT")
                        .mvcMatchers("/students/*").hasAnyRole("ADMIN", "TEACHER", "STUDENT")
//                        .mvcMatchers("/students/*").hasAnyAuthority("READ", "WRITE")
                        .mvcMatchers("/whoami").permitAll()
                        .mvcMatchers("/teachers").hasRole("TEACHER")
                        .anyRequest().denyAll()
        )
        .formLogin()
        .and()
        .httpBasic();

        return httpSecurity.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetailManager()
    {
        List<UserDetails> userDetails = List.of(
                User.builder()
                        .username("teacher")
                        .password("secret")
                        .roles("ADMIN")
                        .build(),
                User.builder()
                        .username("student")
                        .password("secret")
                        .roles("USER")
                        .build()
        );

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
//        return new BCryptPasswordEncoder(12);
        return NoOpPasswordEncoder.getInstance();
    }
}
