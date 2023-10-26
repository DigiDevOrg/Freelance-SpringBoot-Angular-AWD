package com.esprit.microservice.gestions_a.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attachements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private long filesize;
    private String filetype;
    private String uploaddate;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

}
