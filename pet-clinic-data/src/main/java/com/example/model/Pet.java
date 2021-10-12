package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"owner"})
@Data
@Table(name = "pets")
public class Pet extends BaseEntity
{
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private Set<Visit> visits = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "owner_id")
    public Owner getOwner()
    {
        return owner;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    public Set<Visit> getVisits()
    {
        return visits;
    }
}
