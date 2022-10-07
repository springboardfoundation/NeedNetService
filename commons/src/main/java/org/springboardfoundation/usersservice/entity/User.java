package org.springboardfoundation.usersservice.entity;



import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name="user_number")
    private int userNumber;
    private String name;
    private String email;
    private String place;
    private int age;
    private String gender;
    private String occupation;

    private int mobileNumber;

    @OneToOne(mappedBy = "user")
    private UserTrigger trigger;
}
