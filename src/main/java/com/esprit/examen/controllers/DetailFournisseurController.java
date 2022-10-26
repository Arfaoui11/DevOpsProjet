package com.esprit.examen.controllers;
import java.util.List;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.services.IDetailsFournisseursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des details fournisseurs")
@RequestMapping("/detailFournisseur")

public class DetailFournisseurController {
    @Autowired
    IDetailsFournisseursService detailsFournisseursService;

    @GetMapping("/retrieve-all-detailfournisseurs")
    @ResponseBody
    public List<DetailFournisseur> getDetailFournisseurs() {
        List<DetailFournisseur> list = detailsFournisseursService.retrieveAllDetailFournisseur();
        return list;
    }

    @GetMapping("/retrieve-detailfournisseur/{detailfournisseur-id}")
    @ResponseBody
    public DetailFournisseur retrieveDetailFournisseur(@PathVariable("detailfournisseur-id") Long detailfournisseurId) {
        return detailsFournisseursService.retrieveDetailFournisseur(detailfournisseurId);
    }

    @PostMapping("/add-detailfournisseur")
    @ResponseBody
    public DetailFournisseur addDetailFournisseur(@RequestBody DetailFournisseur df) {
        DetailFournisseur detailFournisseur = detailsFournisseursService.addDetailFournisseur(df);
        return detailFournisseur;
    }

    @DeleteMapping("/remove-detailfournisseur/{detailfournisseur-id}")
    @ResponseBody
    public void removeDetailFournisseur(@PathVariable("detailfournisseur-id") Long detailfournisseurId) {
        detailsFournisseursService.deleteDetailFournisseur(detailfournisseurId);
    }

    @PutMapping("/modify-detailfournisseur")
    @ResponseBody
    public DetailFournisseur modifyDetailFournisseur(@RequestBody DetailFournisseur detailFournisseur) {
        return detailsFournisseursService.updateDetailFournisseur(detailFournisseur);

    }
}
