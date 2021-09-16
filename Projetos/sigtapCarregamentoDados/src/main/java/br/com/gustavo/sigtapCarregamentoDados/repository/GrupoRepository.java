package br.com.gustavo.sigtapCarregamentoDados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapCarregamentoDados.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer>{

	Grupo findByCodigo(int codigo);
}
