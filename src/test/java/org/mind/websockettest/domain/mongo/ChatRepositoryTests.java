package org.mind.websockettest.domain.mongo;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.mind.websockettest.domain.entity.Chat;
import org.mind.websockettest.domain.entity.User;
import org.mind.websockettest.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class ChatRepositoryTests {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddChat() {
        User sender = userRepository.findById(1L).orElseThrow();
        User receiver = userRepository.findById(2L).orElseThrow();

        IntStream.rangeClosed(1, 10).forEach(i -> {

            Chat chat = Chat.builder()
                    .content("채팅 테스트" + i)
                    .sender(sender)
                    .receiver(receiver)
                    .isRead(false)
                    .isSenderOut(false)
                    .sendDate(LocalDateTime.now())
                    .build();

            log.info(chatRepository.save(chat).toString());
        });
    }
}
