package metier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;
import metier.entities.Categorie;

@Stateless(name = "CAT")
public class CategorieEJBImpl implements ICategorieLocal, ICategorieRemote {
    @PersistenceContext(unitName = "ProduitEJB")
    private EntityManager em;

    @Override
    public Categorie addCategorie(Categorie cg) {
        em.persist(cg);
        return cg;
    }

    @Override
    public List<Categorie> getCategorie(String key) {
        Query req = em.createQuery("SELECT c FROM Categorie c WHERE c.libelle LIKE :key", Categorie.class);
        req.setParameter("key", "%" + key + "%");
        return req.getResultList();
    }

    @Override
    public void deleteCategorie(Long code) {
        Categorie cg = em.find(Categorie.class, code);
        if (cg != null) {
            em.remove(cg);
        }
    }

    @Override
    public Categorie editCategorie(Categorie cg) {
        return em.merge(cg);
    }

    @Override
    public List<Categorie> listCategorie() {
        return em.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
    }

}
