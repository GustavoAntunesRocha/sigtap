package br.com.gustavo.sigtapAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapAPI.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer>{

	Grupo findByCodigo(int codigo);
}
