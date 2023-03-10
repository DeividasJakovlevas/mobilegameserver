package com.celerity.mobilegameserver.repository;

import com.celerity.mobilegameserver.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero,Long> {
}
