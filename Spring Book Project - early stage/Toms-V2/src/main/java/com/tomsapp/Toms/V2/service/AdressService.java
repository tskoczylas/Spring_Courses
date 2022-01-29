package com.tomsapp.Toms.V2.service;

import com.tomsapp.Toms.V2.entity.Adress;
import com.tomsapp.Toms.V2.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdressService implements AdressServiceInt {

    @Autowired
    AdressRepository adressRepository;




    @Override
    public List<Adress> listofAdreeses() {
        return adressRepository.findAll();
    }

    @Override
    public void save(Adress adress) {
        adressRepository.save(adress);
    }

    @Override
    public void delete(int adressID) {
        adressRepository.deleteById(adressID);
    }

    @Override
    public Adress getById(int adressID) {
        return adressRepository.getOne(adressID);
    }
}
