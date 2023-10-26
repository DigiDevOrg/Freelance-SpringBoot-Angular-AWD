package com.example.microservice_categories_skills.Repository;

import com.example.microservice_categories_skills.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
