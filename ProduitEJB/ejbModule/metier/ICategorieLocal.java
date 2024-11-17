package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Categorie;

@Local
public interface ICategorieLocal {
	public Categorie addCategorie(Categorie cg);

	public List<Categorie> getCategorie(String key);
	
	public void deleteCategorie(Long code);
	
	public Categorie editCategorie(Categorie pr);

	public List<Categorie> listCategorie();
}
