package com.esprit.microservice.gestions_a.Service.Attachements;

import com.esprit.microservice.gestions_a.Entity.Attachements;

import java.util.List;

public interface AttachmentsInt {
    public void addAttachements(Attachements attachements);
    public void updateAttachements(Attachements attachements);
    public void deleteAttachements(Long id);

    public List<Attachements> getAllAttachements();
    public Attachements getAttachementsById(Long id );


}
