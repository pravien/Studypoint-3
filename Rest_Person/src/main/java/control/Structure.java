/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Pravien
 */
public class Structure
{
    public static void main(String[] args)
    {
        HashMap puproperties = new HashMap();
        puproperties.put("javax.persistence.sql-load-script-source","scripts/DropCreate.sql");
        
        Persistence.generateSchema("JPU", puproperties);
        puproperties.remove("javax.persistence.sql-load-script-source");
        
        //puproperties.put("javax.persistence.sql-load-script-source",puproperties);
        
        Persistence.generateSchema("JPU", puproperties);
    
    }
    
}
