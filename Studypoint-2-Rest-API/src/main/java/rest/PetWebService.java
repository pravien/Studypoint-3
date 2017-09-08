/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Json.JSONConverter;
import com.google.gson.JsonObject;
import entity.Pet;
import facade.PetFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Pravien
 */
@Path("pet")
public class PetWebService
{
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
    PetFacade petF = new PetFacade(emf);
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PetWebService
     */
    public PetWebService()
    {
    }
    
    /**
     * Retrieves representation of an instance of rest.PetWebService
     * @return an instance of java.lang.String
     */
    @Path("petcount")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAmountOfPets()
    {
        JSONConverter jC = new JSONConverter();
        //TODO return proper representation object
        List<Pet> pets = petF.getAllPets();
        JsonObject jO = new JsonObject();
        jO.addProperty("petcount", pets.size());
        
        return jO.toString();
    }
    
    @Path("livingpets")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public String getLivingPets()
    {
        JSONConverter jC = new JSONConverter();
        //TODO return proper representation object
        List<Pet> pets = petF.getAllLivingPets();
        
        return jC.getJSONFromPet(pets);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getpets()
    {
        JSONConverter jC = new JSONConverter();
        //TODO return proper representation object
        List<Pet> pets = petF.getAllPets();
        
        return jC.getJSONFromPet(pets);
    }
    

    /**
     * PUT method for updating or creating an instance of PetWebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content)
    {
    }

    private List<JsonObject> ArrayList()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
