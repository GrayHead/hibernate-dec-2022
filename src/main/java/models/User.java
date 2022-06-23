package models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString(exclude = {"passport"})
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @Enumerated(EnumType.STRING)
    private Gendrer gendrer;

    @ElementCollection
    private List<String> skills = new ArrayList<>();



    public User(String name) {
        this.name = name;
    }


    public User(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public User(String name, Passport passport, Gendrer gendrer) {
        this.name = name;
        this.passport = passport;
        this.gendrer = gendrer;
    }

    public User(String name, Passport passport, Gendrer gendrer, List<String> skills) {
        this.name = name;
        this.passport = passport;
        this.gendrer = gendrer;
        this.skills = skills;
    }
}
