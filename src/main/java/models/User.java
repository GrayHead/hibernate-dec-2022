package models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_card",
            joinColumns =
            @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"
            )
    )

    private List<Card> cards;

    public User(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
}
