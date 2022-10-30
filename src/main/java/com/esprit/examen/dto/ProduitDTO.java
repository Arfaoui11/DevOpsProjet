package com.esprit.examen.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
public class ProduitDTO {

    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prix;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;
}
