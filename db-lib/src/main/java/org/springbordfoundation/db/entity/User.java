package org.springbordfoundation.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springboardfoundation.common.entity.Gender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements UserDetails {
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

    private String password;

    private String occupation;
    @Column(name="mobile_number")
    private String mobileNumber;

    @OneToOne(mappedBy = "user")
    private UserTrigger trigger;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mobileNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}