package com.esprit.microservice.gestions_a.Controller;

import com.esprit.microservice.gestions_a.Entity.Services;
import com.esprit.microservice.gestions_a.Service.Services.ServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Service")
public class ServiceController {
    @Autowired
    ServiceInt serviceInt;

     @PostMapping("/addService")
     public void addService(@RequestBody Services services) {
         serviceInt.addService(services);
     }
     @PutMapping("/updateService")
     public void updateService(@RequestBody Services services) {
         serviceInt.updateService(services);
     }
     @DeleteMapping("/deleteService/{id}")
     public void deleteService(@PathVariable Long id) {
         serviceInt.deleteService(id);

     }
     @GetMapping("/getServiceById/{id}")
     public Services getServiceById(@PathVariable Long id) {
         return serviceInt.getServiceById(id);
     }
     @GetMapping("/getAllService")
     public List<Services> getAllService() {

         return serviceInt.getAllService();
     }


}
