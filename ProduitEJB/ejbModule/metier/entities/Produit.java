package metier.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUITS")
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String libelle;
	private double prix;
	private double quantite;
	@ManyToOne
	@JoinColumn(name = "categorie_code")
	private Categorie categorie;
	private static final long serialVersionUID = 1L;

	public Produit() {
		super();
	}

	public Produit(String libelle, double quantite, double prix, Categorie categorie) {
		super();
		this.prix = prix;
		this.libelle = libelle;
		this.quantite = quantite;
		this.categorie = categorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
}
