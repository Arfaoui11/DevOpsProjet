package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DetailsFournisseursServiceImpl implements IDetailsFournisseursService {
    @Autowired
    DetailFournisseurRepository detailFournisseurRepository;
    @Override
    public List<DetailFournisseur> retrieveAllDetailFournisseur () {

        return detailFournisseurRepository.findAll();
    }
    @Override
    public DetailFournisseur addDetailFournisseur(DetailFournisseur df) {
        detailFournisseurRepository.save(df);
        return df;
    }

    @Override
    public void deleteDetailFournisseur(Long id) {
        detailFournisseurRepository.deleteById(id);

    }

    @Override
    public DetailFournisseur updateDetailFournisseur(DetailFournisseur df) {
        detailFournisseurRepository.save(df);
        return df;
    }

    @Override
    public DetailFournisseur retrieveDetailFournisseur(Long id) {
        DetailFournisseur detailFournisseur = detailFournisseurRepository.findById(id).orElse(null);
        return detailFournisseur;
    }
}
