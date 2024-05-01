package go.seoul.serv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detail_cultural_event")
public class DetailCulturalEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_cultural_event_id")
    private int detailCulturalEventId;

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

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "user_trgt")
    private String userTrgt;

    @Column(name = "use_fee")
    private String useFee;

    @Column(name = "program")
    private String program;

    @Column(name = "etc_desc")
    private String etcDesc;

    @Column(name = "org_link")
    private String orgLink;

    @Column(name = "main_image")
    private String mainImage;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "startdate")
    private String startdate;

    @Column(name = "end_date")
    private String endDate;

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
}