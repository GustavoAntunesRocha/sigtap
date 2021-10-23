package br.com.gustavo.sigtapAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.sigtapAPI.model.SubGrupo;
import br.com.gustavo.sigtapAPI.repository.SubGrupoRepository;

@Service
public class SubGrupoService {

	@Autowired
	private SubGrupoRepository subGrupoRepository;
	
	public List<SubGrupo> buscaTodos(){
		return subGrupoRepository.findAll();
	}
	
	public List<SubGrupo> buscaPorGrupo(int codigoGrupo){
		return subGrupoRepository.findByGrupoCodigo(codigoGrupo);
	}
	
	public SubGrupo buscaPorCodigo(int codigo) {
		return subGrupoRepository.findByCodigo(codigo);
	}
}
