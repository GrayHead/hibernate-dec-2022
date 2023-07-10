package models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_card",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "card_id")
    )
    private List<User> users;


    public Card(String number) {
        this.number = number;
    }

    public Card(String number, List<User> users) {
        this.number = number;
        this.users = users;
    }
}
