package com.example.services.springdatajpa;

import com.example.model.Speciality;
import com.example.repositories.SpecialityRepository;
import com.example.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialitiesService
{
    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository)
    {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll()
    {
        Set<Speciality> specialities = new HashSet<>();

        specialityRepository.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality findById(Long id)
    {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality object)
    {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object)
    {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        specialityRepository.deleteById(id);
    }
}
