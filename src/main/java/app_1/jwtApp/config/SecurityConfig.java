package app_1.jwtApp.config;
// this configuration is created to specify which urls can be used before login & which after login


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration      //upon starting project this configuration file will run
public class SecurityConfig {
    
    @Bean //this will create object & details will be stored in it
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {
        http.csrf().disable().cors().disable();

        http.authorizeHttpRequests().anyRequest().permitAll();

        return http.build();
    }

//    @Bean        this is optional for 2nd method of encoding password
//    public PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
