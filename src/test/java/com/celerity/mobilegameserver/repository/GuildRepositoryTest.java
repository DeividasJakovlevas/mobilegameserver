package com.celerity.mobilegameserver.repository;

import com.celerity.mobilegameserver.model.Guild;
import com.celerity.mobilegameserver.model.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GuildRepositoryTest {

    @Mock
    private GuildRepository guildRepository;

    @Test
    void findGuildByName() {
    }

    @Test
    void findByOwner_Token() {
        String token = "token";
        Player owner = new Player(token);
        Guild guild = new Guild("My Guild", owner);
        when(guildRepository.findByOwnerToken(token)).thenReturn(Optional.of(guild));

        Optional<Guild> foundGuild = guildRepository.findByOwnerToken(token);

        assertTrue(foundGuild.isPresent());
        assertEquals(guild, foundGuild.get());
    }

}