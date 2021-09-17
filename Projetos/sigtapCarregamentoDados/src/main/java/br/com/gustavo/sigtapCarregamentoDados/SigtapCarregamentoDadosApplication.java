package br.com.gustavo.sigtapCarregamentoDados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class SigtapCarregamentoDadosApplication {

	public static final String BASE_PATH = "C:\\Users\\gustavo.antunes\\Desktop\\TabelaUnificada_202108_v2108021412";
	public static final String IN_DIR_GRUPOS = BASE_PATH + "\\tb_grupo.txt";
	public static final String IN_DIR_SUBGRUPOS = BASE_PATH + "\\tb_sub_grupo.txt";
	public static final String IN_DIR_FORMAORGANIZACAO = BASE_PATH + "\\tb_forma_organizacao.txt";
	public static final String IN_DIR_PROCEDIMENTOS = BASE_PATH + "\\tb_procedimento.txt";
	
	@Autowired
	private CarregaBD carregaBD;
	
	public static void main(String[] args) {
		SpringApplication.run(SigtapCarregamentoDadosApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void processa() {
		carregaBD.carregaGrupos(IN_DIR_GRUPOS);
		carregaBD.carregaSubGrupos(IN_DIR_SUBGRUPOS);
		carregaBD.carregaFormaOrganizacao(IN_DIR_FORMAORGANIZACAO);
		carregaBD.carregaProcedimentos(IN_DIR_PROCEDIMENTOS);
	}
}
