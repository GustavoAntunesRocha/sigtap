package br.com.gustavo.sigtapAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavo.sigtapAPI.model.SubGrupo;
import br.com.gustavo.sigtapAPI.service.SubGrupoService;

@RestController
@RequestMapping("/sigtap/subGrupo")
public class SubGrupoController {

	@Autowired
	private SubGrupoService service;
	
	@GetMapping("/busca")
	public String getGrupoAll() {
		List<SubGrupo> objList = service.buscaTodos();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(objList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/busca/{codigo}")
	public String getGrupoCodigo(@PathVariable int codigo) {
		SubGrupo obj = service.buscaPorCodigo(codigo);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/busca/{nome}")
	public String getGrupoNome(@PathVariable String nome) {
		List<SubGrupo> obj = service.buscaPorNome(nome);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
