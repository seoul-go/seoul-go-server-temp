package go.seoul.serv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //configuration 으로 등록
@EnableWebSecurity //component 스캔
public class SecurityConfig {
    //SecurityFilterChain interface 를 return 하는 메서드 생성

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.build();
    }
}
