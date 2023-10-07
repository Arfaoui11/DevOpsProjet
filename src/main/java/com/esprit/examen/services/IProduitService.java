package com.esprit.examen.services;

import java.util.List;
import com.esprit.examen.entities.Produit;
import org.springframework.core.io.ByteArrayResource;

public interface IProduitService {

	ByteArrayResource convertDocxToPDF();

	void convertDocx();

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p);

	void deleteProduit(Long id);

	Produit updateProduit(Produit p);

	Produit retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);

}
