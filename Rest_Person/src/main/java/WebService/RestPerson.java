/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Json.JSONConverter;
import com.google.gson.JsonObject;
import entity.Person;
import facade.PersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Pravien
 */
@Path("person")
public class RestPerson
{

    @Context
    private UriInfo context;
    EntityManagerFactory eMF = Persistence.createEntityManagerFactory("JPU");
    PersonFacade personFacade = new PersonFacade();
    JSONConverter jsonCcon = new JSONConverter();
    /**
     * Creates a new instance of RestPerson
     */
    
    public RestPerson()
    {
    }

    /**
     * Retrieves representation of an instance of WebService.RestPerson
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons()
    {
        personFacade.addEntityManagerFactory(eMF);
        String json = jsonCcon.getJSONFromPerson(personFacade.getPersons());
        System.out.println(json.toString());
        return json;
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id)
    {
        personFacade.addEntityManagerFactory(eMF);
        String json = jsonCcon.getJSONFromPerson(personFacade.getPerson(id));
        return json;
    }

    /**
     * PUT method for updating or creating an instance of RestPerson
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(String content)
    {
       personFacade.addEntityManagerFactory(eMF);
        System.out.println("sdas"+content);
       Person p = jsonCcon.getPersonFromJson(content);
        System.out.println(p.toString());
       personFacade.addPerson(p);
       
    }
    
    
    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(String content,@PathParam("id") int id)
    {
       personFacade.addEntityManagerFactory(eMF);
       Person oldP = personFacade.getPerson(id);
       Person newP = jsonCcon.getPersonFromJson(content);
       oldP.setFname(newP.getFname());
       oldP.setLname(newP.getLname());
       oldP.setPhone(newP.getPhone());
       personFacade.editPerson(oldP);
       
    }
    
    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePerson(String content, @PathParam("id") int id)
    {
       personFacade.addEntityManagerFactory(eMF);
       personFacade.deletePerson(id);
       
    }
    
    
    
    
}
