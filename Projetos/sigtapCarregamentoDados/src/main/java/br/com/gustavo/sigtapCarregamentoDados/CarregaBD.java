package br.com.gustavo.sigtapCarregamentoDados;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

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
			linha = br.readLine();
			while ((linha = br.readLine()) != null) {

				linha = removeSinais(linha);
				Grupo grupo = new Grupo(Integer.parseInt(linha.substring(0, 1)), linha.substring(2, 101), linha.substring(102));
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
			linha = br.readLine();
			while ((linha = br.readLine()) != null) {

				linha = removeSinais(linha);
				Grupo grupo = grupoRepository.findByCodigo(Integer.parseInt(linha.substring(0, 1)));
				SubGrupo subGrupo = new SubGrupo(Integer.parseInt(linha.substring(2, 3)), grupo, linha.substring(4, 103), linha.substring(104));
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
			linha = br.readLine();
			while ((linha = br.readLine()) != null) {

				linha = removeSinais(linha);
				Grupo grupo = grupoRepository.findByCodigo(Integer.parseInt(linha.substring(0, 1)));
				SubGrupo subGrupo = subGrupoRepository.findByCodigo(Integer.parseInt(linha.substring(2, 3)));
				FormaOrganizacao formaOrganizacao = new FormaOrganizacao(Integer.parseInt(linha.substring(4, 5)), grupo, subGrupo, linha.substring(6, 105), linha.substring(106));
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
			linha = br.readLine();
			while ((linha = br.readLine()) != null) {

				linha = removeSinais(linha);
				Grupo grupo = grupoRepository.findByCodigo(Integer.parseInt(linha.substring(0, 1)));
				SubGrupo subGrupo = subGrupoRepository.findByCodigo(Integer.parseInt(linha.substring(2, 3)));
				FormaOrganizacao formaOrganizacao = formaOrganizacaoRepository.findByCodigo(Integer.parseInt(linha.substring(4, 5)));
				
				Procedimento procedimento = new Procedimento();
				procedimento.setCodigo(Integer.parseInt(linha.substring(0, 9)));
				procedimento.setGrupo(grupo);
				procedimento.setSubGrupo(subGrupo);
				procedimento.setFormaOrganizacao(formaOrganizacao);
				procedimento.setNome(linha.substring(10, 259));
				procedimento.setComplexidade(linha.substring(0, 0));
				procedimento.setSexo(linha.substring(261, 261));
				procedimento.setQtdMaxima(Integer.parseInt(linha.substring(262, 265)));
				procedimento.setQtdDiasPermanencia(Integer.parseInt(linha.substring(266, 269)));
				procedimento.setQtdPontos(Integer.parseInt(linha.substring(270, 273)));
				procedimento.setIdadeMinima(Integer.parseInt(linha.substring(274, 277)));
				procedimento.setIdadeMaxima(Integer.parseInt(linha.substring(278, 281)));
				procedimento.setValorServicoHospitalar(Integer.parseInt(linha.substring(282, 291)));
				procedimento.setValorServicoAmbulatorial(Integer.parseInt(linha.substring(292, 301)));
				procedimento.setValorServicoProfissional(Integer.parseInt(linha.substring(302, 311)));
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
	
	private static String removeSinais(String entrada) {
		String sa = Normalizer.normalize(entrada, Normalizer.Form.NFD);

		sa = sa.replaceAll("\"", "");
		return sa.replaceAll("\\p{M}", "");
	}
}
