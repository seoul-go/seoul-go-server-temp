package go.seoul.serv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "main_img")
    private String mainImg;

    @Column(name = "codename")
    private String codename;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @Column(name = "place")
    private String place;
}
