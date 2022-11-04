package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operateur implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperateur;
	private String nom;
	private String prenom;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String password;
	@OneToMany
	@JsonIgnore
	private Set<Facture> factures;

	public Operateur(String nom, String prenom, String password,Date dateNaissance) {
		this.nom=nom;
		this.prenom=prenom;
		this.password=password;
		this.dateNaissance=dateNaissance;
	}

	public Operateur(Long idOperateur,String nom, String prenom, String password,Date dateNaissance) {
		this.idOperateur=idOperateur;
		this.nom=nom;
		this.prenom=prenom;
		this.password=password;
		this.dateNaissance=dateNaissance;
	}

	public Operateur(Long idOperateur, String nom, String prenom, String password) {
		this.idOperateur = idOperateur;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}


}
