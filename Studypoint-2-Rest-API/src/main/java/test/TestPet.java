/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import facade.PetFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pravien
 */
public class TestPet
{
   
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
        PetFacade petF = new PetFacade(emf);
        
        
        System.out.println(petF.getAllPets().size());
        System.out.println(petF.getAllPets().toString());
    }
            
}
