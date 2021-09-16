package br.com.gustavo.sigtapCarregamentoDados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapCarregamentoDados.model.SubGrupo;

public interface SubGrupoRepository extends JpaRepository<SubGrupo, Integer>{
	
	SubGrupo findByCodigo(int codigo);

}
