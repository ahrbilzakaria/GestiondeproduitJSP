package metier;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Categorie;

@Remote
public interface ICategorieRemote {
	public Categorie addCategorie(Categorie cg);

	public List<Categorie> getCategorie(String key);
	
	public void deleteCategorie(Long code);
	
	public Categorie editCategorie(Categorie pr);

	public List<Categorie> listCategorie();
}
