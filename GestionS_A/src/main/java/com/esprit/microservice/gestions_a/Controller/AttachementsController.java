package com.esprit.microservice.gestions_a.Controller;

import com.esprit.microservice.gestions_a.Entity.Attachements;
import com.esprit.microservice.gestions_a.Service.Attachements.AttachmentsInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttachementsController {
    @Autowired
    AttachmentsInt attachmentsInt;

     @PostMapping("/addAttachements")
     public void addAttachements(@RequestBody Attachements attachements) {
         attachmentsInt.addAttachements(attachements);
     }
     @PutMapping("/updateAttachements")
     public void updateAttachements(@RequestBody Attachements attachements) {
         attachmentsInt.updateAttachements(attachements);
     }
     @DeleteMapping("/deleteAttachements/{id}")
     public void deleteAttachements(@PathVariable Long id) {
         attachmentsInt.deleteAttachements(id);
     }
     @GetMapping("/getAttachementsById/{id}")
     public Attachements getAttachementsById(@PathVariable Long id) {
         return attachmentsInt.getAttachementsById(id);
    }
     @GetMapping("/getAllAttachements")
     public List<Attachements> getAllAttachements() {
         return attachmentsInt.getAllAttachements();
     }

}
