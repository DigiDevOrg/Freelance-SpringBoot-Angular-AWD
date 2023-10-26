package com.esprit.microservice.gestions_a.Repository;

import com.esprit.microservice.gestions_a.Entity.Attachements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachementsRepository extends JpaRepository<Attachements, Long> {
}
