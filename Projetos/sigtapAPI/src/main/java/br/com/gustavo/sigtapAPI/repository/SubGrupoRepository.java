package br.com.gustavo.sigtapAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapAPI.model.SubGrupo;

public interface SubGrupoRepository extends JpaRepository<SubGrupo, Integer>{
	
	SubGrupo findByCodigo(int codigo);

}
