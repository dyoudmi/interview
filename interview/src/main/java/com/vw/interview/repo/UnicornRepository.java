package com.vw.interview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.interview.model.Unicorn;

@Repository
public interface UnicornRepository extends JpaRepository<Unicorn, Long> {

}
