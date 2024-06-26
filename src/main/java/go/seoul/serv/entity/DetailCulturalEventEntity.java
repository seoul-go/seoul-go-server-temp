package go.seoul.serv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detail_cultural_events")
public class DetailCulturalEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "user_trgt")
    private String userTrgt;

    @Column(name = "use_fee")
    private String useFee;

    @Column(name = "player") // 추가된 필드 'player'
    private String player;

    @Column(name = "program")
    private String program;

    @Column(name = "etc_desc")
    private String etcDesc;

    @Column(name = "org_link")
    private String orgLink;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "themecode")
    private String themecode;

    @Column(name = "lot")
    private double lot;

    @Column(name = "lat")
    private double lat;

    @Column(name = "is_free")
    private String isFree;

    @Column(name = "hmpg_addr")
    private String hmpgAddr;

    // 기본 생성자
    public DetailCulturalEventEntity() {
    }
}