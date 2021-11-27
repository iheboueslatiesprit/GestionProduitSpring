package esprit.spring.controller;

import esprit.spring.entities.Produit;
import esprit.spring.service.ProduitServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@Api(tags= "Produit managment")
public class ProduitRestController {
    @Autowired
    ProduitServiceImpl produitService;
    // http://localhost:8089/SpringMVC/produit/retrieve-all-products
    @GetMapping("/retrieve-all-products")
    @ResponseBody
    @ApiOperation(value ="Récupérer la liste des produits")
    public List<Produit> getProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        return listProduits;
    }

    //http://localhost:8089/SpringMVC/produit/add-product
    @PostMapping("/add-product")
    @ResponseBody
    @ApiOperation(value ="permet d'ajouter un produit")
    public Produit addProduit(@RequestBody Produit c,Long idRayon,Long idStock) {

        Produit product = produitService.addProduit(c,idRayon,idRayon);
        return product;
    }
    //http://localhost:8089/SpringMVC/produit/retrieve-produit/3
    @GetMapping("/retrieve-produit/{produit-id}")
    @ResponseBody
    @ApiOperation(value ="Permet de récuperer un produit avec son id")
    public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
        return produitService.retrieveProduit(produitId);
    }

}