package com.esprit.examen.services;

import java.util.Date;
import java.util.List;

import com.esprit.examen.entities.Produit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

@Service
@Slf4j
public class OperateurServiceImpl implements IOperateurService {

	@Autowired
	OperateurRepository  operateurRepository;
	@Override
	public List<Operateur> retrieveAllOperateurs() {
		log.info("In method retrieveAllOperateurs");
		List<Operateur> operateurs = (List<Operateur>) operateurRepository.findAll();
		for (Operateur op : operateurs) {
			log.info(" Operateur: " + op);
		}
		log.info(" out of retrieveAllOperateurs");
		return operateurs;
	}

	@Override
	public Operateur addOperateur(Operateur op) {
		log.info("In method addOperateur");
		operateurRepository.save(op);
		return op;
	}

	@Override
	public void deleteOperateur(Long id) {
		log.info("In method deleteOperateur");
		operateurRepository.deleteById(id);
		
	}

	@Override
	public Operateur updateOperateur(Operateur o) {
		log.info("In method updateOperateur");
		operateurRepository.save(o);
		return o;
	}

	@Override
	public Operateur retrieveOperateur(Long id) {
		log.info("In method retrieveOperateur");
		Operateur op =  operateurRepository.findById(id).orElse(null);
		log.info(" Operateur: " + op);
		return  op;
	}

	@Override
	public List<Operateur> getOperateurByDateNaissance(Date d1, Date d2) {
		log.info("In method getOperateurByDateNaissance");
		return operateurRepository.retrieveOperateursByDateNaissance(d1,d2);
	}

}
