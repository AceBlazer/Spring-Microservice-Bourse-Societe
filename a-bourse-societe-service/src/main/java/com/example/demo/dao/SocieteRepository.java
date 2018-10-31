package com.example.demo.dao;


import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Societe;

@RepositoryRestResource
public interface SocieteRepository extends JpaRepository<Societe, Long>{
	
	@Query("select s from Societe s where s.nomSociete like :mc")
	public Page<Societe> societesparmc(@Param("mc")String mc, Pageable page);
	
	
}
