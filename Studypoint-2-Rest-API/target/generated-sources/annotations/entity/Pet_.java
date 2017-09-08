package entity;

import entity.Event;
import entity.Owner;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-08T12:48:20")
@StaticMetamodel(Pet.class)
public class Pet_ { 

    public static volatile ListAttribute<Pet, Event> eventList;
    public static volatile SingularAttribute<Pet, Date> death;
    public static volatile SingularAttribute<Pet, String> species;
    public static volatile SingularAttribute<Pet, String> name;
    public static volatile SingularAttribute<Pet, Date> birth;
    public static volatile SingularAttribute<Pet, Integer> id;
    public static volatile SingularAttribute<Pet, Owner> ownerId;

}