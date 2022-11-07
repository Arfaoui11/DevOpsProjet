package com.esprit.examen.dto;

import lombok.Data;

@Data
public class StockDTO {
    private String libelleStock;
    private Integer qte;
    private Integer qteMin;
}
