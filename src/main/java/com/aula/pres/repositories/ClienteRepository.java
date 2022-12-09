package com.aula.pres.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.pres.model.Cidade;
import com.aula.pres.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	public List<Cliente> findByCidade(Cidade cidade);

}
