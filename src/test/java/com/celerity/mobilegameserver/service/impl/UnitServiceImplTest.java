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
import com.celerity.mobilegameserver.model.Unit;
import com.celerity.mobilegameserver.repository.UnitRepository;

class UnitServiceImplTest {

    @Mock
    private UnitRepository unitRepository;

    @InjectMocks
    private UnitServiceImpl unitService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        unitService = new UnitServiceImpl(unitRepository);
    }

    @Test
    public void testGetAllUnits() {
        List<Unit> units = new ArrayList<>();
        units.add(new Unit());
        units.add(new Unit());
        when(unitRepository.findAll()).thenReturn(units);

        List<Unit> result = unitService.getAllUnits();

        assertEquals(2, result.size());
        verify(unitRepository, times(1)).findAll();
    }

    @Test
    public void testGetUnitByIdSuccess() {
        Unit unit = new Unit();
        unit.setId(1L);
        Optional<Unit> optionalUnit = Optional.of(unit);
        when(unitRepository.findById(1L)).thenReturn(optionalUnit);

        Unit result = unitService.getUnitById(1L);

        assertEquals(unit, result);
        verify(unitRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetUnitByIdNotFound() {
        when(unitRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> unitService.getUnitById(1L));
        verify(unitRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateUnit() {
        Unit unit = new Unit();
        unit.setId(1L);
        when(unitRepository.save(any(Unit.class))).thenReturn(unit);

        Unit result = unitService.createUnit(new Unit());

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(unitRepository, times(1)).save(any(Unit.class));
    }

    @Test
    public void testUpdateUnitSuccess() {
        Unit unit = new Unit();
        unit.setId(1L);
        Optional<Unit> optionalUnit = Optional.of(unit);
        when(unitRepository.findById(1L)).thenReturn(optionalUnit);
        when(unitRepository.save(any(Unit.class))).thenReturn(unit);

        Unit updatedUnit = new Unit();
        updatedUnit.setLevel(2);
        updatedUnit.setStars((byte) 2);
        Unit result = unitService.updateUnit(1L, updatedUnit);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(2, result.getLevel());
        assertEquals(2, result.getStars());
        verify(unitRepository, times(1)).findById(1L);
        verify(unitRepository, times(1)).save(any(Unit.class));
    }
}