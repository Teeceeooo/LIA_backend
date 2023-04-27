package Entities;

import Repository.CountryRepository;

import java.util.List;

public class Country implements CountryRepository {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Country findById(Long id) {
        return null;
    }

    @Override
    public void save(Country country) {

    }

    @Override
    public List<Country> findAll() {
        return null;
    }
}
