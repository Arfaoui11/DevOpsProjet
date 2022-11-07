package com.esprit.examen.services;

import java.util.Date;
import java.util.List;
import com.esprit.examen.entities.Operateur;


public interface IOperateurService {

	List<Operateur> retrieveAllOperateurs();

	Operateur addOperateur(Operateur o);

	void deleteOperateur(Long id);

	Operateur updateOperateur(Operateur o);

	Operateur retrieveOperateur(Long id);

	List<Operateur> getOperateurByDateNaissance(Date d1, Date d2);

}
