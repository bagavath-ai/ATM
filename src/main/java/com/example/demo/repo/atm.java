package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.atmtable;

public interface atm extends JpaRepository<atmtable, Integer>{

}
