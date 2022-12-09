package com.aula.pres.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.pres.model.Cidade;
import com.aula.pres.model.Cliente;
import com.aula.pres.services.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui um cliente da base de dados")
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);	
	}
	
	@PutMapping
	@ApiOperation(value = "Altera um cliente da base de dados")
		public Cliente alterar(@RequestBody Cliente c) {
		return service.alterar(c);
		
	}
	
	@PostMapping
	@ApiOperation(value = "Insere um cliente da base de dados")
	public Cliente inserirCidade(@RequestBody Cliente c) {
		return service.incluir(c);
		
	}
	
	@GetMapping
	@ApiOperation(value = "Lista todos os clientes da base de dados")
	public List<Cliente> listarTodos(){
		return service.listarTodos();
	}
	
	@GetMapping("/buscaporcidade/{cidade}")
	@ApiOperation(value = "Lista os clientes da base de dados de uma cidade específica")
	public List<Cliente> buscarPorCidade(@PathVariable("cidade") Cidade cidade){
		return service.buscarPorCidade(cidade);
	}

}
