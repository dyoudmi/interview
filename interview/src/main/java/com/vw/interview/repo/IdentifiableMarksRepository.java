package com.vw.interview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.interview.model.IdentifiableMarks;

@Repository
public interface IdentifiableMarksRepository extends JpaRepository<IdentifiableMarks, Long> {

}
