package com.esprit.microservice.gestions_a.Repository;

import com.esprit.microservice.gestions_a.Entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Services, Long> {
}
