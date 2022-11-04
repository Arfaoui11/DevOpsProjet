package com.esprit.examen.controllers;

import java.util.List;

import com.esprit.examen.dto.SecteurActiviteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.services.ISecteurActiviteService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des secteurs activites")
@RequestMapping("/secteurActivite")
@CrossOrigin("*")
public class SecteurActiviteController {

	@Autowired
	ISecteurActiviteService secteurActiviteService;

	@Autowired
	private ModelMapper modelMapper;
	

	@GetMapping("/retrieve-all-secteurActivite")
	@ResponseBody
	public List<SecteurActivite> getSecteurActivite() {
		return secteurActiviteService.retrieveAllSecteurActivite();
	}


	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public SecteurActivite retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
	}


	@PostMapping("/add-secteurActivite")
	@ResponseBody
	public SecteurActivite addSecteurActivite(@RequestBody SecteurActiviteDTO sa) {
			SecteurActivite persistentSecteur = modelMapper.map(sa,  SecteurActivite.class);
		return secteurActiviteService.addSecteurActivite(persistentSecteur );
	}


	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
	}


	@PutMapping("/modify-secteurActivite")
	@ResponseBody
	public SecteurActivite modifySecteurActivite(@RequestBody SecteurActiviteDTO secteurActivite) {
		SecteurActivite persistentSecteur = modelMapper.map(secteurActivite,  SecteurActivite.class);
		return secteurActiviteService.updateSecteurActivite(persistentSecteur);
	}

	
}
