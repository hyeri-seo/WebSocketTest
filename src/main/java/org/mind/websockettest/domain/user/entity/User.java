package org.mind.websockettest.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @ColumnDefault("USER")
    private String role;

    @ColumnDefault("NORMAL")
    private String social;

    @ColumnDefault("true")
    private Boolean isActive;

    @ColumnDefault("false")
    private Boolean isBanned;
}
