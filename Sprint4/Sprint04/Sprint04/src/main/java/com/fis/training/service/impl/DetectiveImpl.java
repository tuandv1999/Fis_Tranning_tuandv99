package com.fis.training.service.impl;


import com.fis.training.model.CriminalCase;
import com.fis.training.model.Detective;
import com.fis.training.model.core.Rank;
import com.fis.training.repository.CriminalCaseRepository;
import com.fis.training.repository.DetectiveRepository;
import com.fis.training.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetectiveImpl implements DetectiveService {
    @Autowired
    DetectiveRepository detectiveRepository;
    @Autowired
    CriminalCaseRepository criminalCaseRepository;


    @Override
    public Detective findById(Long id) {
        return detectiveRepository.findById(id).get();
    }

    @Override
    public Detective createDetective(Detective detective) {
         detectiveRepository.save(detective);
        return detective;
    }

    @Override
    public Detective updateDetective(Detective detective) {
        return detectiveRepository.save(detective);
    }

    @Override
    public void deleteDetectiveById(Long detectiveId) {
        Detective detective  = detectiveRepository.getById(detectiveId);
        detectiveRepository.delete(detective);
    }

    @Override
    public List<Detective> findAll() {
        return detectiveRepository.findAll();
    }

    @Override
    public Detective findByRank(Rank rank) {
        Detective detective=detectiveRepository.findByRank(rank);
        return detective;
    }
}
