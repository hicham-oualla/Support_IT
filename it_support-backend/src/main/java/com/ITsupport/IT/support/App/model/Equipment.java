package com.ITsupport.IT.support.App.model;

import com.ITsupport.IT.support.App.model.enums.EquipmentStatut;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipementId;
    private String name;
    private String UrlImg;
    private String description;
    @Enumerated(EnumType.STRING)
    private EquipmentStatut statut;



    @OneToMany(mappedBy = "equipment")
    @JsonIgnore
    private List<Ticket> tickets;


}