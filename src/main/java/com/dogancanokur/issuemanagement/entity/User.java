package com.dogancanokur.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname", length = 100, unique = true, nullable = false)
    private String username;

    @Column(name = "pwd", length = 200, nullable = false)
    private String password;

    @Column(name = "name_surname", length = 100, nullable = false)
    private String nameSurname;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;
}
