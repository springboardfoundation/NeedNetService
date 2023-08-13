package org.springboardfoundation.usersservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="otp")
public class Otp {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column( name="mobile_number")
    private String mobileNumber;

    @Column(unique=true, name="uniqueId")
    private String uniqueId;
}
