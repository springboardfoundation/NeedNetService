package org.springboardfoundation.usersservice.entity;



import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springboardfoundation.usersservice.gender.Gender;

@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name="user_indentifier")
    private String userIdentifier;
    private String name;
    private String email;
    private String place;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String occupation;
    @Column(name="mobile_number")
    private String mobileNumber;

    @OneToOne(mappedBy = "user")
    private UserTrigger trigger;
}
