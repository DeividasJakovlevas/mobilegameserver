package com.celerity.mobilegameserver.service;

import com.celerity.mobilegameserver.model.Hero;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface HeroService {
    List<Hero> getAllHeroes();

    Optional<Hero> getHeroById(Long id);

    Hero createHero(Hero hero);

    Hero updateHero(Long id, Hero hero);

    void deleteHero(Long id);
}
