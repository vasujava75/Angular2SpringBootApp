package com.affinitas.personApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.affinitas.personApp.domain.Questions;


@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {

}
