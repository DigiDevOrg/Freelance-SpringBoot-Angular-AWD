package com.esprit.microservice.gestions_a.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//import attachments;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private String title;
    private String description;
    private double price;
    private int delivery_time;
    private double average_rating;
    private String category;
    private String image;  // You can store the image as a file path or as a blob

    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attachements> atachements;
}
