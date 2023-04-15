package com.example.Todo.demo.models;
//import java.sql.Date;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;


@Entity
@Table(
        name = "users"
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public User(String login, String surname, String lastname, String middlename, java.sql.Date birthday) {
        this.login = login;
        this.surname = surname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
    }

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String surname;
    private String firstname;
    private String lastname;
    private String middlename;
    private Date birthday;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modify_date;

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
}