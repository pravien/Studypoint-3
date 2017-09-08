package generator;


import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pravien
 */
public class Generator
{
    List<String> fnames = new ArrayList();
    List<String> lnames = new ArrayList();
    List<JsonObject> maps;
    
    public void addFnames(){
        fnames.add("anders");
        fnames.add("bo");
        fnames.add("carl");
        fnames.add("daniel");
        fnames.add("emil");
        fnames.add("Frank");
    }
    
    public void addLnames(){
       lnames.add("andersen");
       lnames.add("bosen");
       lnames.add("carlsen");
       lnames.add("danielsen");
       lnames.add("emilsen");
       lnames.add("Franksen"); 
    }
    
    public String generator(int amount,int startId){
       addLnames();
       addFnames();
        maps = new ArrayList();
        for (int i = 0; i < amount; i++)
        {
          JsonObject jO = new JsonObject();
          Random rn = new Random();
           System.out.println(startId);
           jO.addProperty("fname", fnames.get(randomValue(fnames.size()-1,0)));
           jO.addProperty("lname", lnames.get(randomValue(lnames.size()-1,0)));
           jO.addProperty("id",startId);
           jO.addProperty("age",randomValue(70,17));
           maps.add(jO);
           startId++; 
        }
        
        return maps.toString();
    }
    
    public  int randomValue(int maxVaulue, int minValue){
        
       return ((int) (Math.random()*(maxVaulue - minValue))) + minValue;
    }
    
}
