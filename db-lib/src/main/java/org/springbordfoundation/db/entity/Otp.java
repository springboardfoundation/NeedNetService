package org.springbordfoundation.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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