package go.seoul.serv.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
@Getter
@Setter
@Entity
public class MainCulturalEvent {
    @Id
    private int mainCulturalEventId;
    private String codename;
    private String guname;
    private String title;
    private String date;
    private String place;
    private String mainImage;

}
