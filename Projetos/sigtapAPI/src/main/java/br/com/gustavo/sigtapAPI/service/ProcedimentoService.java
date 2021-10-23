package br.com.gustavo.sigtapAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.sigtapAPI.model.Procedimento;
import br.com.gustavo.sigtapAPI.repository.ProcedimentoRepository;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public Procedimento buscaPorCodigo(int codigo) {
		return procedimentoRepository.getById(codigo);
	}
	
	public List<Procedimento> buscaPorFormaOrganizacao(int codigoOrganizacao){
		return procedimentoRepository.findByFormaOrganizacaoCodigo(codigoOrganizacao);
	}
	
	public List<Procedimento> buscaPorSubGrupo(int codigoSubGrupo){
		return procedimentoRepository.findBySubGrupoCodigo(codigoSubGrupo);
	}
	
	public List<Procedimento> buscaPorGrupo(int codigoGrupo){
		return procedimentoRepository.findByGrupoCodigo(codigoGrupo);
	}
}
