package com.esprit.microservice.gestions_a.Service.Services;


import com.esprit.microservice.gestions_a.Entity.Services;

import java.util.List;

public interface ServiceInt {
    public void addService(Services services);
    public void updateService(Services services);
    public void deleteService(Long id);
    public Services getServiceById(Long id );
    public List<Services> getAllService();
}
