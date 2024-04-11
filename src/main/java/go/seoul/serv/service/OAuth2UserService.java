package go.seoul.serv.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User=super.loadUser(userRequest);

        //registration 에서 넘어온 값 출처 확인
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        if (registrationId.equals("naver")) {
            //네이버 데이터는 json 방식, response key 내부에 정보 존재

        } else if (registrationId.equals("google")) {
            //구글은 json 외부에 정보가 존재

        } else {
            return null;
        }
    }

}
