package org.springbordfoundation.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="needs")
public class Need {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    private String needId;
    private String title;
    private String type;
    private String description;
    private Date startDate;
    private Date endDate;
    private String additionalInfo;
    private String status;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_identifier", referencedColumnName = "id")
    private User user; 
}