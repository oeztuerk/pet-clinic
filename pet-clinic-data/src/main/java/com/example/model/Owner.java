package com.example.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="owners")
public class Owner extends Person
{
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;
    private Set<Pet> pets = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    public Set<Pet> getPets()
    {
        return pets;
    }
}
