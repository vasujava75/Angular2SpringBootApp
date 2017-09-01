package com.affinitas.personApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.affinitas.personApp.domain.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
