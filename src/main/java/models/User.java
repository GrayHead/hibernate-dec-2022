package models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String name;
    private String email;

    @ElementCollection
    private List<String> skills = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name =  "passport_id",referencedColumnName = "id")
    private Passport passport;

    public User(String name, String email, List<String> skills, Gender gender) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.gender = gender;
    }

    public User(String name, String email, List<String> skills, Gender gender, Passport passport) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.gender = gender;
        this.passport = passport;
    }
}
