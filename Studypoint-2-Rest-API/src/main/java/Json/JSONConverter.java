/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.Pet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Pravien
 */
public class JSONConverter
{
  public static Pet getPetFromJson(String js){
      return new Gson().fromJson(js, Pet.class);
  }  
  public static String getJSONFromPet(Pet p) {
      
      return new Gson().toJson(p);
  } 
  
  public static String getJSONFromPet(List<Pet> list){
      List<Pet> pets = list;
        List<JsonObject> jsonObjects = new ArrayList();
        for(int i = 0; i<pets.size();i++){
            Pet p = pets.get(i);
            JsonObject jO = new JsonObject();
            jO.addProperty("id",pets.get(i).getId());
            jO.addProperty("birth", p.getBirth().toString());
            jO.addProperty("death", p.getDeath().toString());
            jO.addProperty("name", p.getName());
            jO.addProperty("species", p.getSpecies());
            jO.addProperty("firstName",p.getOwnerId().getFirstName());
            jO.addProperty("lastName",p.getOwnerId().getLastName());
            jsonObjects.add(jO);
        }
        return jsonObjects.toString();
  }
    
}
