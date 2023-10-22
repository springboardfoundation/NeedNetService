package org.springboardfoundation.dbservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "otp")
public class Otp {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(unique = true, name = "uniqueId")
    private String uniqueId;
}