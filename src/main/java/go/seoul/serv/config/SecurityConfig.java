package go.seoul.serv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //configuration 으로 등록을 위한 annotation
@EnableWebSecurity //component 스캔을 위한 annotation
public class SecurityConfig {
    //SecurityFilterChain interface 를 return 하는 메서드 생성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //csrf disable
        http
                .csrf((auth) -> auth.disable());//csrf 공격을 방어하는 메서드, jwt 발급 후 stateless 상태로 관리하기 때문에 꺼놓음

        //From 로그인 방식 disable
        http
                .formLogin((auth) -> auth.disable());//jwt, OAuth 방식으로 로그인을 하기 때문에 From 방식 꺼놓음

        //HTTP Basic 인증 방식 disable
        http
                .httpBasic((auth) -> auth.disable());//jwt, OAuth 방식으로 로그인을 하기 때문에 Http 방식 꺼놓음

        //oauth2
        http
                .oauth2Login(Customizer.withDefaults());//커스텀 구현은 추후에, 현재는 default 설정

        //경로별 인가 작업
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/").permitAll()//route 경로는 permit all
                        .anyRequest().authenticated());//나머지 경로는 로그인한 사용자만 접근하도록 authenticated

        //세션 설정 : STATELESS
        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));//jwt로 인증 인가를 진행하기 때문에 STATELESS

        return http.build();
    }
}
