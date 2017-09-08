/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pravien
 */
public class Populate
{
    
    
        public static void main(String[] args)
    {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("JPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person user = new Person("bobo", "Sørensen", "4545454");
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
        
    
}
