package models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String series;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "passport",fetch = FetchType.LAZY)
    private User user;


    public Passport(String series) {
        this.series = series;
    }
}
