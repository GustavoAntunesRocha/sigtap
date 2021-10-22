package br.com.gustavo.sigtapAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapAPI.model.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer>{

}
