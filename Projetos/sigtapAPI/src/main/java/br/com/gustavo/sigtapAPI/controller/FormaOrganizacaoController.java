package br.com.gustavo.sigtapAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavo.sigtapAPI.model.FormaOrganizacao;
import br.com.gustavo.sigtapAPI.service.FormaOrganizacaoService;

@RestController
@RequestMapping("/sigtap/formaOrganizacao")
public class FormaOrganizacaoController {

	@Autowired
	private FormaOrganizacaoService service;
	
	@GetMapping("/busca")
	public String getFormaOrganizacaoAll() {
		List<FormaOrganizacao> objList = service.buscaTodos();
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
	public String getFormaOrganizacaoCodigo(@PathVariable int codigo) {
		FormaOrganizacao obj = service.buscaPorCodigo(codigo);
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
	public String getFormaOrganizacaoNome(@PathVariable String nome) {
		List<FormaOrganizacao> obj = service.buscaPorNome(nome);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/busca/subGrupo/{codigo}")
	public String getFormaOrganizacaoSubGrupo(@PathVariable int codigo) {
		List<FormaOrganizacao> obj = service.buscaPorSubGrupo(codigo);
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
