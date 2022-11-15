package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {

	List<TransactionEntity> findAll();
}
