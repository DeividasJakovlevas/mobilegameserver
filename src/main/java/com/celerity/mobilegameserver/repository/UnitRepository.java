package com.celerity.mobilegameserver.repository;

import com.celerity.mobilegameserver.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit,Long> {
}
