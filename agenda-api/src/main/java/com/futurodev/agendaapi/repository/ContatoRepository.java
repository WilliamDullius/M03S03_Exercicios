package com.futurodev.agendaapi.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.futurodev.agendaapi.models.ContatoModel;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
	
	@Query ("select c from ContatoModel c where c.nome like %?1%")
	ArrayList<ContatoModel> getContatoByName (String nome);
	
}