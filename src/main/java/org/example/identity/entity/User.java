package org.example.identity.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_0311") // 可以不要，默认用“user”
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(name = "name")
    String name;

    @Column
    String email;

    @Column
    String phone;

    @Column
    String address;

    @Column
    int age;

    @Column
    String nation;

    @Column
    String passwd;
}
