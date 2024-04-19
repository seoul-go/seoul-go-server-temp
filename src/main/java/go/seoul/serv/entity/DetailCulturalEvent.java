package go.seoul.serv.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
@Getter
@Setter
@Entity
public class DetailCulturalEvent {
    @Id
    private int detailCulturalEventId;
    private String codename;
    private String guname;
    private String title;
    private String date;
    private String place;
    private String orgName;
    private String userTrgt;
    private String useFee;
    private String program;
    private String themecode;
    private double lot;
    private double lat;
    private String isFree;
    private String hmpgAddr;
    private String mainImage;
    private String ticket;


}
