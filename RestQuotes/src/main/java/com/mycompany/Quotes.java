/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.Quote;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
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
@Path("quote")
public class Quotes
{

    @Context
    private UriInfo context;
    private static Map<Integer, String> quotes = new HashMap()
    {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }
    };
    /**
     * Creates a new instance of Quotes
     */
    public Quotes()
    {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.Quotes
     *
     * @return an instance of java.lang.String
     */
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonById(@PathParam("id") int id)
    {
        JsonObject jO = new JsonObject();
        jO.addProperty("id", id);
        jO.addProperty("quote",quotes.get(id));
        
        return jO.toString();
    }
    
    
    @Path("random")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomQuote()
    {
        quotes.size();
        int randId = (int)(Math.random() * quotes.size()) + 1;
        JsonObject jO = new JsonObject();
        jO.addProperty("id", randId);
        jO.addProperty("quote",quotes.get(randId));
        return jO.toString();
    }
    
    public int generateMapKey(){
        int i=1;
        while(true){
            if(!quotes.containsKey(i)){
                return i;
            }
            i++;
        }
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String addQuote(String content)
    {
        Quote q1 = new Gson().fromJson(content, Quote.class);
        JsonObject jO = new JsonObject();
        int key = generateMapKey();
        quotes.put(key,q1.getQuoteText());
        jO.addProperty("id", key);
        jO.addProperty("quote", q1.getQuoteText());
        return jO.toString();
    }

    /**
     * PUT method for updating or creating an instance of Quotes
     *
     * @param content representation for the resource
     */
    @Path("{id}")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content, @PathParam("id") int id)
    {
        Quote q1 = new Gson().fromJson(content, Quote.class);
        System.out.println(quotes.get(id));
        quotes.put(id, q1.getQuoteText());
        System.out.println(quotes.get(id));
        JsonObject jO = new JsonObject();
        jO.addProperty("id", id);
        jO.addProperty("quote", q1.getQuoteText());
        //int k = Integer.parseInt(context.getPathParameters().get("id").toString());
        return jO.toString();
    }
    
    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) 
    public String deleteQuote(String content,@PathParam("id") int id){
        JsonObject jO = new JsonObject();
        jO.addProperty("quote",quotes.get(id));
        quotes.remove(id);
        return jO.toString();
    }
}
