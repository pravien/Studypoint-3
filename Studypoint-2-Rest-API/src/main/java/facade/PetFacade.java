/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Pet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pravien
 */
public class PetFacade
{
    EntityManagerFactory emf;
    
    public PetFacade (EntityManagerFactory emf){
        this.emf = emf;
    }
    
    public List<Pet> getAllPets(){
       List<Pet> returnArray = new ArrayList();
       EntityManager em = emf.createEntityManager();
       try
        {
            em.getTransaction().begin();
            returnArray = em.createNamedQuery("Pet.findAll").getResultList();
            em.getTransaction().commit();
            return returnArray;
        } finally
        {
            em.close();
        }
    }
    
    public void addPet(Pet p){
      EntityManager em = emf.createEntityManager();
      try
      {
          em.getTransaction().begin();
          em.persist(p);
          em.getTransaction().commit();
      } finally
        {
            em.close();
        }
    }
    
    
   public List<Pet> getAllLivingPets(){
       List<Pet> returnArray = new ArrayList();
       EntityManager em = emf.createEntityManager();
       try
        {
            em.getTransaction().begin();
            returnArray = em.createNamedQuery("Pet.findNotDeathPets").getResultList();
                    //.getResultList();
            em.getTransaction().commit();
            return returnArray;
        } finally
        {
            em.close();
        }
    }
    
}
