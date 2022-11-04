package com.esprit.examen.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class ReglementDTO {
    private Long idReglement;
    private float montantPaye;
    private float montantRestant;
    private Boolean payee;
    @Temporal(TemporalType.DATE)
    private Date dateReglement;
}
