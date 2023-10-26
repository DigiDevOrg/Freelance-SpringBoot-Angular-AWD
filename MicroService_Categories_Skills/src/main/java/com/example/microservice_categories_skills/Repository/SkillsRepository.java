package com.example.microservice_categories_skills.Repository;

import com.example.microservice_categories_skills.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
}
