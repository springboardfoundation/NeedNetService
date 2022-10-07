package org.springboardfoundation.usersservice.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_trigger")
public class UserTrigger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userNumber", referencedColumnName = "id")
	private User user;

	private String responseId;

	private String responseCode;
}
