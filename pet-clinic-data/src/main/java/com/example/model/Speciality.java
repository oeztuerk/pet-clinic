package com.example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "specialities")
public class Speciality extends BaseEntity
{
    private String description;

    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }
}
