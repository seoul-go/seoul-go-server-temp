//package go.seoul.serv.dto;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Map;
//
//public class CustomOAuth2User implements OAuth2User {
//    //생성자를 통해 해당 userdto 를 받음
//    private final UserDTO userDTO;
//
//    public CustomOAuth2User(UserDTO userDTO) {
//        this.userDTO = userDTO;
//    }
//
//    @Override
//    public Map<String, Object> getAttributes() {
//        return null;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collection = new ArrayList<>();
//
//        collection.add(new GrantedAuthority() {
//
//            @Override
//            public String getAuthority() {
//
//                return userDTO.getRole();
//            }
//        });
//
//        return collection;
//    }
//
//    @Override
//    public String getName() {
//        return userDTO.getName();
//    }
//    //받은 userdto에서 getName을 넣어주고 username을 따로 사용할 수 있도록 함
//    public String getUsername() {
//        return userDTO.getUsername();
//    }
//}
