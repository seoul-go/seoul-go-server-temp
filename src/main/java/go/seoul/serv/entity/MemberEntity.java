package go.seoul.serv.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "MEMBER")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // For JPA
@AllArgsConstructor  // Required by Lombok when using @Builder
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String nickName;

    @Column(nullable = false)
    private Integer age;
}
