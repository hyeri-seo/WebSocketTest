package org.mind.websockettest.domain.chat.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.mind.websockettest.domain.user.entity.User;

import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @Column(nullable = false)
    private String content;

    @ColumnDefault("false")
    private Boolean isRead;

    @CreationTimestamp
    private LocalDateTime sendDate;

    @ColumnDefault("false")
    private Boolean isSenderOut;

    @ColumnDefault("false")
    private Boolean isReceiverOut;
}
