package ro.devdepot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Column(name = "email")
    private String email;
    @Column(name = "userrole")
    private UserRole userRole;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    @OneToMany
    @JoinTable(
            name="user_address",
            joinColumns = @JoinColumn( name="user_id"),
            inverseJoinColumns = @JoinColumn( name="address_id")
    )
    private List<Address> addresses;

}
