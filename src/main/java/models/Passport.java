package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String series;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "passport")
    @ToString.Exclude
    private User user;

    public Passport(String series) {
        this.series = series;
    }
}

