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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aula.pres.model.Cidade;
import com.aula.pres.services.CidadeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeService service;
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui uma cidade da base de dados")
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);	
	}
	
	
	@PutMapping
	@ApiOperation(value = "Altera uma cidade da base de dados")
	//public Cidade alterar(@RequestBody Cidade c, @RequestParam("id") int id) {
		public Cidade alterar(@RequestBody Cidade c) {
		//c.setId(id);
		return service.alterar(c);
		
	}
	
	@PostMapping
	@ApiOperation(value = "Insere uma cidade na base de dados")
	public Cidade inserirCidade(@RequestBody Cidade c) {
		return service.incluir(c);
		
	}
	
	@GetMapping
	@ApiOperation(value = "Lista todas as cidades da base de dados")
	public List<Cidade> listarTodas(){
		return service.listarTodas();
	}
	
	@GetMapping("/buscauf/{uf}")
	@ApiOperation(value = "Lista as cidades da base de dados de uma UF específica")
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf){
		return service.buscarPoruf(uf);
	}
	
}
