package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFournisseur;

import java.util.List;

public interface IDetailsFournisseursService {

    List<DetailFournisseur> retrieveAllDetailFournisseur ();

    DetailFournisseur addDetailFournisseur(DetailFournisseur df);

    void deleteDetailFournisseur(Long id);
    DetailFournisseur updateDetailFournisseur(DetailFournisseur df);

    DetailFournisseur retrieveDetailFournisseur(Long id);
}
