package com.celerity.mobilegameserver.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.celerity.mobilegameserver.exception.ResourceNotFoundException;
import com.celerity.mobilegameserver.model.Hero;
import com.celerity.mobilegameserver.repository.HeroRepository;

class HeroServiceImplTest {

    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private HeroServiceImpl heroService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        heroService = new HeroServiceImpl(heroRepository);
    }

    @Test
    public void testGetAllHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero());
        heroes.add(new Hero());
        when(heroRepository.findAll()).thenReturn(heroes);

        List<Hero> result = heroService.getAllHeroes();

        assertEquals(2, result.size());
        verify(heroRepository, times(1)).findAll();
    }

    @Test
    public void testGetHeroByIdSuccess() {
        Hero hero = new Hero();
        hero.setId(1L);
        Optional<Hero> optionalHero = Optional.of(hero);
        when(heroRepository.findById(1L)).thenReturn(optionalHero);

        Optional<Hero> result = heroService.getHeroById(1L);

        assertTrue(result.isPresent());
        assertEquals(hero, result.get());
        verify(heroRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetHeroByIdNotFound() {
        when(heroRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> heroService.getHeroById(1L));
        verify(heroRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateHero() {
        Hero hero = new Hero();
        hero.setId(1L);
        when(heroRepository.save(any(Hero.class))).thenReturn(hero);

        Hero result = heroService.createHero(new Hero());

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(heroRepository, times(1)).save(any(Hero.class));
    }

    @Test
    public void testUpdateHeroSuccess() {
        Hero hero = new Hero();
        hero.setId(1L);
        Optional<Hero> optionalHero = Optional.of(hero);
        when(heroRepository.findById(1L)).thenReturn(optionalHero);
        when(heroRepository.save(any(Hero.class))).thenReturn(hero);

        Hero updatedHero = new Hero();
        updatedHero.setLevel(2);
        updatedHero.setStars((byte) 2);
        Hero result = heroService.updateHero(1L, updatedHero);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(2, result.getLevel());
        assertEquals(2, result.getStars());
        verify(heroRepository, times(1)).findById(1L);
        verify(heroRepository, times(1)).save(any(Hero.class));
    }
}