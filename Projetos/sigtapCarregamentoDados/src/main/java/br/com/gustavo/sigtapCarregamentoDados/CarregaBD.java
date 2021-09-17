package br.com.gustavo.sigtapCarregamentoDados;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.sigtapCarregamentoDados.model.FormaOrganizacao;
import br.com.gustavo.sigtapCarregamentoDados.model.Grupo;
import br.com.gustavo.sigtapCarregamentoDados.model.Procedimento;
import br.com.gustavo.sigtapCarregamentoDados.model.SubGrupo;
import br.com.gustavo.sigtapCarregamentoDados.repository.FormaOrganizacaoRepository;
import br.com.gustavo.sigtapCarregamentoDados.repository.GrupoRepository;
import br.com.gustavo.sigtapCarregamentoDados.repository.ProcedimentoRepository;
import br.com.gustavo.sigtapCarregamentoDados.repository.SubGrupoRepository;

@Service
public class CarregaBD {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private SubGrupoRepository subGrupoRepository;
	
	@Autowired
	private FormaOrganizacaoRepository formaOrganizacaoRepository;
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	
	public void carregaGrupos(String path) {
		BufferedReader br = null;
		String linha = "";
		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
			while ((linha = br.readLine()) != null) {

				Grupo grupo = new Grupo(Integer.parseInt(linha.substring(0, 2)), linha.substring(2, 102), linha.substring(102));
				grupoRepository.save(grupo);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void carregaSubGrupos(String path) {
		BufferedReader br = null;
		String linha = "";
		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
			while ((linha = br.readLine()) != null) {

				Grupo grupo = grupoRepository.findByCodigo(Integer.parseInt(linha.substring(0, 2)));
				SubGrupo subGrupo = new SubGrupo(Integer.parseInt(linha.substring(2, 4)), grupo, linha.substring(4, 104), linha.substring(104));
				subGrupoRepository.save(subGrupo);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void carregaFormaOrganizacao(String path) {
		BufferedReader br = null;
		String linha = "";
		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
			while ((linha = br.readLine()) != null) {

				Grupo grupo = grupoRepository.findByCodigo(Integer.parseInt(linha.substring(0, 2)));
				SubGrupo subGrupo = subGrupoRepository.findByCodigo(Integer.parseInt(linha.substring(2, 4)));
				FormaOrganizacao formaOrganizacao = new FormaOrganizacao(Integer.parseInt(linha.substring(4, 6)), grupo, subGrupo, linha.substring(6, 106), linha.substring(106));
				formaOrganizacaoRepository.save(formaOrganizacao);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void carregaProcedimentos(String path) {
		BufferedReader br = null;
		String linha = "";
		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
			while ((linha = br.readLine()) != null) {

				Grupo grupo = grupoRepository.findByCodigo(Integer.parseInt(linha.substring(0, 2)));
				SubGrupo subGrupo = subGrupoRepository.findByCodigo(Integer.parseInt(linha.substring(2, 4)));
				FormaOrganizacao formaOrganizacao = formaOrganizacaoRepository.findByCodigo(Integer.parseInt(linha.substring(4, 6)));
				
				Procedimento procedimento = new Procedimento();
				procedimento.setCodigo(Integer.parseInt(linha.substring(0, 10)));
				procedimento.setGrupo(grupo);
				procedimento.setSubGrupo(subGrupo);
				procedimento.setFormaOrganizacao(formaOrganizacao);
				procedimento.setNome(linha.substring(10, 260));
				procedimento.setComplexidade(linha.substring(260, 261));
				procedimento.setSexo(linha.substring(261, 262));
				procedimento.setQtdMaxima(Integer.parseInt(linha.substring(262, 266)));
				procedimento.setQtdDiasPermanencia(Integer.parseInt(linha.substring(266, 270)));
				procedimento.setQtdPontos(Integer.parseInt(linha.substring(270, 274)));
				procedimento.setIdadeMinima(Integer.parseInt(linha.substring(274, 278)));
				procedimento.setIdadeMaxima(Integer.parseInt(linha.substring(278, 282)));
				procedimento.setValorServicoHospitalar(Integer.parseInt(linha.substring(282, 292)));
				procedimento.setValorServicoAmbulatorial(Integer.parseInt(linha.substring(292, 302)));
				procedimento.setValorServicoProfissional(Integer.parseInt(linha.substring(302, 312)));
				procedimento.setDataCompetencia(linha.substring(324));
				procedimentoRepository.save(procedimento);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
