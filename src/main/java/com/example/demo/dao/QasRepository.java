package com.example.demo.dao;

import com.example.demo.model.Qas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QasRepository extends JpaRepository<Qas,Integer> {
}
