package com.yourname.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "`AppUser`")
@Table(name = "`AppUser`")
public class AppUser {

    @Id
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

    @Column
    @CreationTimestamp
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime createDateTime;
}
