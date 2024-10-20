package org.project.wowprofessionweb.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String itemLvl;
    private String description;
    private String maxInStack;
    private String sellingPrice;
    private String typeCurrency;
    private String urlImage;
    private long idItem;
}
