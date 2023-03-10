package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.exception.ResourceNotFoundException;
import com.celerity.mobilegameserver.model.Hero;
import com.celerity.mobilegameserver.repository.HeroRepository;
import com.celerity.mobilegameserver.service.HeroService;

import java.util.List;
import java.util.Optional;

public class HeroServiceImpl implements HeroService {

    private HeroRepository heroRepository;

    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Optional<Hero> getHeroById(Long id) {
        Optional<Hero> optionalHero = heroRepository.findById(id);

        if (optionalHero.isPresent()) {
            return optionalHero;
        }else{
            throw new ResourceNotFoundException("Hero","id", id.toString());
        }
    }


    public Hero createHero(Hero hero) {
        return heroRepository.save(hero);
    }
    public Hero createStartingHeroes(Hero hero) {
        return heroRepository.save(hero);
    }
    public Hero updateHero(Long id, Hero hero) {
        Optional<Hero> optionalHero = heroRepository.findById(id);

        if (optionalHero.isPresent()) {
            Hero existingHero = optionalHero.get();
            existingHero.setLevel(hero.getLevel());
            existingHero.setStars(hero.getStars());
            return heroRepository.save(existingHero);
        } else {
            throw new ResourceNotFoundException("Hero","id", id.toString());
        }
    }

    public void deleteHero(Long id) {
        Optional<Hero> optionalHero = heroRepository.findById(id);

        if (optionalHero.isPresent()) {
            heroRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Hero","id", id.toString());
        }
    }
}
