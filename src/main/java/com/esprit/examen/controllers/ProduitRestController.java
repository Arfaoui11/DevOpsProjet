package com.esprit.examen.controllers;


import java.util.List;

import com.esprit.examen.dto.ProduitDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;

import io.swagger.annotations.Api;
import org.springframework.web.client.HttpClientErrorException;


@RestController
@Api(tags = "Gestion des produits")
@RequestMapping(value = "/produit",produces = "application/json;charset=UTF-8")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		return produitService.retrieveAllProduits();
	}

	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	/* Ajouter en produit tout en lui affectant la catégorie produit et le stock associés */
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody ProduitDTO p) {
		Produit persistentProduit = modelMapper.map(p,  Produit.class);

		return  produitService.addProduit( persistentProduit);
	}


	@GetMapping("/pdf")
	@ResponseBody
	public ResponseEntity<ByteArrayResource> generatePdf() {
	try {
		ByteArrayResource fileResponse = produitService.convertDocxToPDF();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
				.header(HttpHeaders.CONTENT_DISPOSITION)
				.body(fileResponse);
	}catch (HttpClientErrorException ex)
	{
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@GetMapping("/savePDF")
	@ResponseBody
	public ResponseEntity<HttpStatus> generateAndSavePdf() {
		try {
			produitService.convertDocx();
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (HttpClientErrorException ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody ProduitDTO p) {
        Produit persistentProduit = modelMapper.map(p,  Produit.class);
		return produitService.updateProduit(persistentProduit);
	}

	/*
	 * Si le responsable magasin souhaite modifier le stock du produit il peut
	 * le faire en l'affectant au stock en question
	 */
	@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}



}
