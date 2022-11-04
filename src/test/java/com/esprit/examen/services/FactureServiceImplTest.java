package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Operateur;

import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {
	@Autowired
	IFactureService factureService; 
	@Autowired
	IOperateurService operateurService; 
	@Autowired
	IFournisseurService fournisseurService; 
	
	
	
	@Test
	public void testAddFacture () throws  ParseException  {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateFormat.parse("30/09/2000");
		Date date2 = dateFormat.parse("30/09/2000");
		

		Facture f = new Facture(20f,200f,date1,date2,true);
		Facture savedFactrure= factureService.addFacture(f);
		System.out.print("client "+savedFactrure);
		assertNotNull(savedFactrure);
		factureService.cancelFacture(savedFactrure.getIdFacture());;
		
		
	} 
	
	@Test
    public void testCancelFacture() throws  ParseException  {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateFormat.parse("30/09/2000");
		Date date2 = dateFormat.parse("30/09/2000");
		Facture f = new Facture(20f,200f,date1,date2,true);
		Facture savedFactrure= factureService.addFacture(f);
		factureService.cancelFacture(savedFactrure.getIdFacture());
	    assertEquals(savedFactrure.getArchivee(),true);

     }
	@Test
	public void testRetrieveAllFactures() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateFormat.parse("30/09/2000");
		Date date2 = dateFormat.parse("30/09/2000");
		List<Facture> factures =  factureService.retrieveAllFactures();
		int expected =factures.size();
		Facture f = new Facture(20f,200f,date1,date2,true);
		Facture savedFactrure= factureService.addFacture(f);
		
		assertEquals(expected + 1,factureService.retrieveAllFactures().size());
		factureService.cancelFacture(savedFactrure.getIdFacture());
	}
		@Test
		public void testRetrieveFacturesById() throws ParseException {
		    Long a = new Long(1);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = dateFormat.parse("30/09/2000");
			Date date2 = dateFormat.parse("30/09/2000");
			Facture f = new Facture(a,20f,200f,date1,date2,true);
			Facture savedFactrure= factureService.addFacture(f);
			factureService.retrieveFacture(a);
			factureService.cancelFacture(savedFactrure.getIdFacture());

			


	}
	@Test
	public void testgetFacturesByFournisseur() throws ParseException  {
		Long a = new Long(1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateFormat.parse("30/09/2000");
		Date date2 = dateFormat.parse("30/09/2000");
		Facture f = new Facture(20f,200f,date1,date2,true);
		Facture savedFactrure= factureService.addFacture(f);
		Set<Facture> f1  = new HashSet<Facture>();
		f1.add(savedFactrure); 
     	Fournisseur fournisseur = new Fournisseur(a,"112","aaa",f1);
		Fournisseur savedFournisseur= fournisseurService.addFournisseur(fournisseur);		
		List<Facture> factures = factureService.getFacturesByFournisseur(a);
		assertNotNull(fournisseur.getIdFournisseur());
		log.info(" count" +  factures.size());
		for (Facture facture : factures) {
		log.info(" facture: " + facture.getMontantFacture()+ " né le "+facture.getMontantRemise());

		}
	}
	@Test
	public void testassignOperateurToFacture() throws ParseException{
		Long a = new Long(1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateFormat.parse("30/09/2000");
		Date date2 = dateFormat.parse("30/09/2000");
		Facture f = new Facture(20f,200f,date1,date2,true);
		Operateur o = new Operateur(a,"chaima","yahyaoui","123");
		Facture savedFactrure= factureService.addFacture(f);
		Operateur operateurSaved =  operateurService.addOperateur(o);
		factureService.assignOperateurToFacture(a,a); 	
	}
	/*
	 @Test
		public void  pourcentageRecouvrement() throws ParseException{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = dateFormat.parse("30/09/2000");
			Date endDate = dateFormat.parse("30/09/2000");
			factureService.pourcentageRecouvrement(startDate, endDate);
		}

*/
}

*/

