package com.example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "visits")
public class Visit extends  BaseEntity
{
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;

    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    public Pet getPet()
    {
        return pet;
    }
}
