package org.mind.websockettest.domain.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.mind.websockettest.WebSocketTestApplication;
import org.mind.websockettest.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@Log4j2
@SpringBootTest(classes = WebSocketTestApplication.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            User user = User.builder()
                    .email("user" + i + "@naver.com")
                    .nickname("유저" + i)
                    .password("pw")
                    .role("USER")
                    .social("NORMAL")
                    .isActive(true)
                    .isBanned(false)
                    .build();

            log.info("user_id" + userRepository.save(user).getId());
        });
    }
}
