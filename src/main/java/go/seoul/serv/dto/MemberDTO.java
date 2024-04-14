package go.seoul.serv.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDTO {
    private String username;
    private String password;
    private String name;
    private String nickName;
    private Integer age;
}
