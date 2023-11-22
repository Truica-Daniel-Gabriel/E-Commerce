package ro.devdepot.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    private String username;
    @Setter(value = AccessLevel.NONE)
    @Column(name = "password")
    private String password;
    @Column(name = "userrole")
    private UserRole userRole;
}
