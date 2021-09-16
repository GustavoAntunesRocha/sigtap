package br.com.gustavo.sigtapCarregamentoDados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapCarregamentoDados.model.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer>{

}
