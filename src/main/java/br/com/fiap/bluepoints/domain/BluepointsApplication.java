package br.com.fiap.bluepoints.domain;

import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.repository.PessoaRepository;
import br.com.fiap.bluepoints.domain.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BluepointsApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaService;

	public static void main(String[] args) {
		SpringApplication.run(BluepointsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var qtd = pessoaService.count();
		if(qtd > 0)return;
		var matheus = Pessoa.builder()
				.nome("MATHEUS FELIPE")
				.sobrenome("CAMARINHA DUARTE")
				.pontos(50000)
				.build();
		pessoaService.save(matheus);

	}
}
