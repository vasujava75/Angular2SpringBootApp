package com.affinitas.personApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.affinitas.personApp.domain.Answers;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {

}
