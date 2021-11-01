package br.com.gustavo.sigtapAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavo.sigtapAPI.model.Procedimento;
import br.com.gustavo.sigtapAPI.service.ProcedimentoService;

@RestController
@RequestMapping("/sigtap/procedimento")
public class ProcedimentoController {

	@Autowired
	private ProcedimentoService service;
	
	@GetMapping("/busca/{codigo}")
	public String getProcedimentoCodigo(@PathVariable int codigo) {
		Procedimento obj = service.buscaPorCodigo(codigo).get();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/busca/FormaOrganizacao/{codigo}")
	public String getProcedimentoFormaOrganizacao(@PathVariable int codigo) {
		List<Procedimento> objList = service.buscaPorFormaOrganizacao(codigo);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(objList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/busca/subGrupo/{codigo}")
	public String getProcedimentoSubGrupo(@PathVariable int codigo) {
		List<Procedimento> objList = service.buscaPorSubGrupo(codigo);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(objList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/procedimento/busca/Grupo/{codigo}")
	public String getProcedimentoGrupo(@PathVariable int codigo) {
		List<Procedimento> objList = service.buscaPorGrupo(codigo);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(objList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
