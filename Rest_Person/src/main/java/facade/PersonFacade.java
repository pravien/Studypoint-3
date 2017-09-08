/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pravien
 */
public class PersonFacade implements IPersonFacade
{
    EntityManagerFactory emf;
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf)
    {
       this.emf = emf;
    }

    @Override
    public Person addPerson(Person p)
    {
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
        
        return p;
    }

    @Override
    public Person deletePerson(int id)
    {
        EntityManager em = emf.createEntityManager();
        Person p;
       try
        {
            em.getTransaction().begin();
            long lId =  id; 
            p = em.find(Person.class, lId);
            em.remove(p);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
       return p;
    }

    @Override
    public Person getPerson(int id)
    {
        EntityManager em = emf.createEntityManager();
        Person p;
       try
        {
            em.getTransaction().begin();
            long lId =  id;
            p = em.find(Person.class, lId);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        } 
       return p;
    }

    @Override
    public List<Person> getPersons()
    {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = new ArrayList();
       try
        {
            em.getTransaction().begin();
            persons = em.createNamedQuery("Person.findAll").getResultList();
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
       return persons;
    }

    @Override
    public Person editPerson(Person p)
    {
        EntityManager em = emf.createEntityManager();
       try
        {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
       return p;
    }
    
    
}
