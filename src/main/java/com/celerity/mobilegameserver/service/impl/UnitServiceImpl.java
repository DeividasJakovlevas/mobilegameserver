package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.exception.ResourceNotFoundException;
import com.celerity.mobilegameserver.model.Unit;
import com.celerity.mobilegameserver.repository.UnitRepository;
import com.celerity.mobilegameserver.service.UnitService;

import java.util.List;
import java.util.Optional;

public class UnitServiceImpl implements UnitService {

    private UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Unit getUnitById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit","id", id.toString()));
    }

    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    public Unit updateUnit(Long id, Unit unit) {
        Unit existingUnit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit","id", id.toString()));
            existingUnit.setLevel(unit.getLevel());
            existingUnit.setStars(unit.getStars());
            return unitRepository.save(existingUnit);
    }
}
