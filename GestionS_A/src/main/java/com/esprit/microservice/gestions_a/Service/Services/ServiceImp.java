package com.esprit.microservice.gestions_a.Service.Services;

import com.esprit.microservice.gestions_a.Entity.Services;
import com.esprit.microservice.gestions_a.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImp implements ServiceInt {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public void addService(Services services) {
        serviceRepository.save(services);
    }
    @Override
    public void updateService(Services services) {
        serviceRepository.save(services);
    }
    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
    @Override
    public Services getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
    @Override
    public List<Services> getAllService() {
        return serviceRepository.findAll();
    }
}
