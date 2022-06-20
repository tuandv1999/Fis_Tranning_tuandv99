package com.fresher.repository.jpa;

import com.fresher.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriminalRepository  extends JpaRepository<CriminalCase,Long> {
    CriminalCase getById(Long id);
}
