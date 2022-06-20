package com.fresher.service.Impl;

import com.fresher.model.CriminalCase;
import com.fresher.repository.jpa.CriminalRepository;
import com.fresher.service.CrinimalSevice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CrinimalCaseImpl implements CrinimalSevice {
    @Autowired CriminalRepository criminalcaseRepository;
    @Override
    public CriminalCase findById(Long id) {
        return criminalcaseRepository.getById(id);
    }

    @Override
    public CriminalCase createCriminalCase(CriminalCase criminalCase) {
        return criminalcaseRepository.save(criminalCase);
    }

    @Override
    public CriminalCase updateCriminalCase( CriminalCase criminalCase) {
            return criminalcaseRepository.save(criminalCase);
    }

    @Override
    public void deleteCriminalCaseById(Long criminalCaseId) {
        CriminalCase criminalCase  =criminalcaseRepository.getById(criminalCaseId);
        criminalcaseRepository.delete(criminalCase);
    }


    @Override
    public List<CriminalCase> findAll() {
        return criminalcaseRepository.findAll();
    }
}
