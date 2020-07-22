package com.example.demo.dao;

import com.example.demo.model.Context;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContextRepository extends JpaRepository<Context,Integer> {
}
