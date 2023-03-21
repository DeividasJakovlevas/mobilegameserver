package com.celerity.mobilegameserver.service;

import com.celerity.mobilegameserver.model.Unit;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UnitService {
    List<Unit> getAllUnits();

    Unit getUnitById(Long id);

    Unit createUnit(Unit unit);

    Unit updateUnit(Long id, Unit unit);
    
}
