package br.com.fiap.bluepoints.domain;

import br.com.fiap.bluepoints.domain.entity.Foto;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.entity.Reciclagem;
import br.com.fiap.bluepoints.domain.repository.FotoRepository;
import br.com.fiap.bluepoints.domain.repository.PessoaRepository;
import br.com.fiap.bluepoints.domain.repository.ReciclagemRepository;
import br.com.fiap.bluepoints.domain.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BluepointsApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaService;

	@Autowired
	private FotoRepository fotoRepository;

	@Autowired
	private ReciclagemRepository reciclagemRepository;

	public static void main(String[] args) {
		SpringApplication.run(BluepointsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var matheus = Pessoa.builder()
				.nome("MATHEUS FELIPE")
				.sobrenome("CAMARINHA DUARTE")
				.pontos(50000)
				.build();

		var foto1 = Foto.builder()
				.src("TEStE")
				.build();

		var reciclagem1 = Reciclagem.builder()
				.pessoa(matheus)
				.foto(foto1)
				.pontos(0)
				.isValidado(false)
				.build();
		reciclagemRepository.save(reciclagem1);

	}
}
