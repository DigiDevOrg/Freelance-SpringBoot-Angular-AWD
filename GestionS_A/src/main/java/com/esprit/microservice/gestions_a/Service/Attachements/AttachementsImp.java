package com.esprit.microservice.gestions_a.Service.Attachements;

import com.esprit.microservice.gestions_a.Entity.Attachements;
import com.esprit.microservice.gestions_a.Repository.AttachementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachementsImp implements AttachmentsInt {

    @Autowired
    AttachementsRepository attachementsRepository;

    @Override
    public void addAttachements(Attachements attachements) {
        attachementsRepository.save(attachements) ;
    }

    @Override
    public void updateAttachements(Attachements attachements) {

        attachementsRepository.save(attachements) ;

    }



    @Override
    public void deleteAttachements(Long id) {
        attachementsRepository.deleteById(id);

    }

    @Override
    public List<Attachements> getAllAttachements() {
       return attachementsRepository.findAll();
    }

    @Override
    public Attachements getAttachementsById(Long id) {
        return attachementsRepository.findById(id).orElse(null);
    }



}
