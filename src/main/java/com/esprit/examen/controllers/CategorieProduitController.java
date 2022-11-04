package com.esprit.examen.controllers;

import java.util.List;

import com.esprit.examen.dto.CategorieProduitDTO;

import org.modelmapper.ModelMapper;
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
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.services.ICategorieProduitService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des categories Produit")
@RequestMapping("/categorieProduit")
public class CategorieProduitController {

	@Autowired
	ICategorieProduitService categorieProduitService;


	@Autowired
	private ModelMapper modelMapper;
	

	@GetMapping("/retrieve-all-categorieProduit")
	@ResponseBody
	public List<CategorieProduit> getCategorieProduit() {
		return categorieProduitService.retrieveAllCategorieProduits();
	}


	@GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
	}


	@PostMapping("/add-categorieProduit")
	@ResponseBody
	public CategorieProduit addCategorieProduit(@RequestBody CategorieProduitDTO cp) {
		CategorieProduit persistentC = modelMapper.map(cp,  CategorieProduit.class);
		return categorieProduitService.addCategorieProduit(persistentC );
	}


	@DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		categorieProduitService.deleteCategorieProduit(categorieProduitId);
	}


	@PutMapping("/modify-categorieProduit")
	@ResponseBody
	public CategorieProduit modifyCategorieProduit(@RequestBody CategorieProduitDTO categorieProduit) {
		CategorieProduit persistentC = modelMapper.map(categorieProduit,  CategorieProduit.class);
		return categorieProduitService.updateCategorieProduit(persistentC);
	}

	
}
