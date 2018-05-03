package com.zisal.springbootcxfsecuredbasic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Data
@EqualsAndHashCode
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 50, unique = true)
    private String code;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "password", length = 150)
    private String password;

    @Column(name = "enabled")
    private Integer enabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "link_user_role",
            joinColumns = {@JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            )}
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String code, String name, String password, Integer enabled, Set<Role> roles) {
        this.code = code;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }


}
