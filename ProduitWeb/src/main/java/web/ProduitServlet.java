package web;

import java.io.IOException;
import java.util.List;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.ICategorieLocal;
import metier.IProduitLocal;
import metier.entities.*;

@WebServlet(name ="cs",urlPatterns ="*.do")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IProduitLocal metierProduit;
	@EJB
	private ICategorieLocal metierCategorie;
	
    public ProduitServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("categories", metierCategorie.listCategorie());
		session.setAttribute("produits", metierProduit.listProduits());
		response.sendRedirect("Categorie.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        String action = request.getParameter("action");
	        
	        String designation = null;
	        double prix = 0;
	        int quantite = 0;
	        String cat = null;
	        Long code = null;
	        Long codeCat = null;
	        String description = null;
	        String libelle = null;
	        Produit p = null;
	        Categorie c = null;
	        List<Categorie> categorie = null;
	        switch(action) {
	            case "Ajouter":
	            	designation = request.getParameter("designation");
	            	prix = Double.parseDouble(request.getParameter("prix"));
	            	quantite = Integer.parseInt(request.getParameter("quantite"));
	            	cat = request.getParameter("categorie");
	            	categorie = metierCategorie.getCategorie(cat);
	            	System.out.print(categorie.get(0).getLibelle());
                    p = new Produit(designation, quantite, prix, categorie.get(0));
                    metierProduit.addProduit(p);
	                break;
	                
	            case "AjouterCat":
	            	libelle = request.getParameter("libelle");
	            	description = request.getParameter("description");
                    c = new Categorie(libelle,description);
                    metierCategorie.addCategorie(c);
                    session.setAttribute("categories", metierCategorie.listCategorie());
        	        response.sendRedirect("Categorie.jsp");
                    return;
	                
	            case "Modifier":
                    code = Long.parseLong(request.getParameter("code"));
                    designation = request.getParameter("designation");
	            	prix = Double.parseDouble(request.getParameter("prix"));
	            	quantite = Integer.parseInt(request.getParameter("quantite"));
	            	cat = request.getParameter("categorie");
	            	categorie = metierCategorie.getCategorie(cat);
                    p = new Produit(designation, quantite, prix, categorie.get(0));
                    p.setCode(code);
                    metierProduit.editProduit(p);
                    break;
                    
	            
	            case "ModifierCat":
                    codeCat = Long.parseLong(request.getParameter("codeCat"));
                    libelle = request.getParameter("libelle");
	            	description = request.getParameter("description");
                    c = new Categorie(libelle,description);
                    c.setCode(codeCat);
                    metierCategorie.editCategorie(c);
                    session.setAttribute("categories", metierCategorie.listCategorie());
        	        response.sendRedirect("Categorie.jsp");
                    return;

	            case "Rechercher":
	            	designation = request.getParameter("designation");
                    List<Produit> produits = metierProduit.getProduit(designation);
                    session.setAttribute("produits", produits);
        	        response.sendRedirect("Produit.jsp");
                    return;
                    
	            case "RechercherCat":
	            	libelle = request.getParameter("libelle");
                    List<Categorie> categories = metierCategorie.getCategorie(libelle);
                    session.setAttribute("categories", categories);
        	        response.sendRedirect("Categorie.jsp");
                    return;
                    
	            case "+ Quantite":             
                    code = Long.parseLong(request.getParameter("code"));
                    quantite = Integer.parseInt(request.getParameter("quantite"));
                    metierProduit.ajouterQte(code, quantite);
	                break;

	            case "- Quantite":
                    code = Long.parseLong(request.getParameter("code"));
                    quantite = Integer.parseInt(request.getParameter("quantite"));
                    metierProduit.retirerQte(code, quantite);
                    break;
                    
	            case "Supprimer":
                    code = Long.parseLong(request.getParameter("codeToDelete"));
                    metierProduit.deleteProduit(code);
	                break;
	                
	            case "SupprimerCat":
                    code = Long.parseLong(request.getParameter("codeToDeleteCat"));
                    metierCategorie.deleteCategorie(code);
                    session.setAttribute("categories", metierCategorie.listCategorie());
                    session.setAttribute("produits", metierProduit.listProduits());
        	        response.sendRedirect("Categorie.jsp");
                    return;

	            default:
	                request.setAttribute("error", "Invalid action");
	                request.getRequestDispatcher("Produit.jsp").forward(request, response);
	                return;
	        }

	        session.setAttribute("produits", metierProduit.listProduits());
	        response.sendRedirect("Produit.jsp");
	}

}
