package com.aula.pres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.pres.model.Cidade;
import com.aula.pres.model.Cliente;
import com.aula.pres.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository rep;
	
	public List<Cliente> listarTodos(){
		return rep.findAll();
	}
	
	public void excluir(Integer id) {
		Cliente clienteExcluir = rep.findById(id).get();
		if(clienteExcluir != null) {
			rep.delete(clienteExcluir);
		}
	}
	
	public Cliente incluir(Cliente c) {
		return rep.save(c);
		
	}
	
	public Cliente alterar(Cliente c) {
		return rep.save(c);
		
	}
	
	public List<Cliente> buscarPorCidade(Cidade cidade){
		return rep.findByCidade(cidade);
	}
}




