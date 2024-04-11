package go.seoul.serv.dto;

public interface OAuth2Response {

    //제공자
    String getProvider();

    //제공자에서 발급해주는 ID(번호)
    String getProviderId();

    //사용자 이메일
    String getEmail();

    //사용자 이름
    String getName();


}
