package com.aula.pres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.pres.model.Cidade;
import com.aula.pres.repositories.CidadeRepository;

@Service
public class CidadeService {
	

		
		@Autowired
		CidadeRepository rep;
		
		public List<Cidade> buscarPoruf(String uf){
			return rep.findByUf(uf);
		}
		
		
		public void excluir(Integer id) {
			Cidade cidadeExcluir = rep.findById(id).get();
			if(cidadeExcluir != null) {
				rep.delete(cidadeExcluir);
			}
		}
		
		public Cidade incluir(Cidade c) {
			return rep.save(c);
			
		}
		
		public List<Cidade>listarTodas(){
			return rep.findAll();
		}
		
		public Cidade alterar(Cidade c) {
			return rep.save(c);
			
		}
	}

