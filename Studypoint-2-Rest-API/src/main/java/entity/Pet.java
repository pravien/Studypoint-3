/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Pravien
 */
@Entity
@Table(name = "pet")
@NamedQueries(
{
    @NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p"),
    @NamedQuery(name = "Pet.findById", query = "SELECT p FROM Pet p WHERE p.id = :id"),
    @NamedQuery(name = "Pet.findByBirth", query = "SELECT p FROM Pet p WHERE p.birth = :birth"),
    @NamedQuery(name = "Pet.findByDeath", query = "SELECT p FROM Pet p WHERE p.death = :death"),
    @NamedQuery(name = "Pet.findNotDeathPets", query = "SELECT p FROM Pet p WHERE p.death != NULL"),
    @NamedQuery(name = "Pet.findByName", query = "SELECT p FROM Pet p WHERE p.name = :name"),
    @NamedQuery(name = "Pet.findBySpecies", query = "SELECT p FROM Pet p WHERE p.species = :species")
})
public class Pet implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Column(name = "death")
    @Temporal(TemporalType.DATE)
    private Date death;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "species")
    private String species;
    @OneToMany(mappedBy = "petId")
    private List<Event> eventList;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne
    private Owner ownerId;

    public Pet()
    {
    }

    public Pet(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getBirth()
    {
        return birth;
    }

    public void setBirth(Date birth)
    {
        this.birth = birth;
    }

    public Date getDeath()
    {
        return death;
    }

    public void setDeath(Date death)
    {
        this.death = death;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSpecies()
    {
        return species;
    }

    public void setSpecies(String species)
    {
        this.species = species;
    }

    public List<Event> getEventList()
    {
        return eventList;
    }

    public void setEventList(List<Event> eventList)
    {
        this.eventList = eventList;
    }

    public Owner getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(Owner ownerId)
    {
        this.ownerId = ownerId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet))
        {
            return false;
        }
        Pet other = (Pet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Pet[ id=" + id + " ]";
    }
    
}
