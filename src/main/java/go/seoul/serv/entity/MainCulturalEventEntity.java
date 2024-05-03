package go.seoul.serv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "main_cultural_events")
public class MainCulturalEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터베이스에서 ID가 자동으로 생성되는 경우 사용
    @Column(name = "id") // 데이터베이스 컬럼 이름 명시
    private int id;

    @Column(name = "codename")
    private String codename;

    @Column(name = "guname")
    private String guname;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @Column(name = "place")
    private String place;

    @Column(name = "main_image")
    private String mainImage;

    //기본 생성자
    public MainCulturalEventEntity() {

    }

}
