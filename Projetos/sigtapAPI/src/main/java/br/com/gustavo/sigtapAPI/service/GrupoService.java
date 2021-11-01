package br.com.gustavo.sigtapAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.sigtapAPI.model.Grupo;
import br.com.gustavo.sigtapAPI.repository.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	public List<Grupo> buscaTodos(){
		return grupoRepository.findAll();
	}
	
	public List<Grupo> buscaPorNome(String nome){
		return grupoRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public Grupo buscaPorCodigo(int codigo) {
		return grupoRepository.findByCodigo(codigo);
	}
}
