//package go.seoul.serv.dto;
//
//import java.util.Map;
//
//public class NaverResponse implements OAuth2Response {
//    //OAuth2UserService가 데이터를 집어 넣어주려면 생성자로 구현해야 함
//    private final Map<String, Object> attribute;
//
//    //생성자를 Map 으로 받아줌
//    public NaverResponse(Map<String, Object> attribute) {
//        //초기화
//        this.attribute = (Map<String, Object>) attribute.get("response");
//        //naver 경우 이중키 형식으로 response 키에 데이터가 있어서 response 라는 키에 get을 함
//
//    }
//
//    @Override
//    public String getProvider() {
//        return "naver";
//    }
//
//    @Override
//    public String getProviderId() {
//        return attribute.get("id").toString();
//    }
//
//    @Override
//    public String getEmail() {
//        return attribute.get("email").toString();
//    }
//
//    @Override
//    public String getName() {
//        return attribute.get("name").toString();
//    }
//}
