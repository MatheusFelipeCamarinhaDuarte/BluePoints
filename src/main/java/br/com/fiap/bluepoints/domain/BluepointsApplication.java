package br.com.fiap.bluepoints.domain;

import br.com.fiap.bluepoints.domain.entity.Foto;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.entity.Reciclagem;
import br.com.fiap.bluepoints.domain.entity.Usuario;
import br.com.fiap.bluepoints.domain.repository.FotoRepository;
import br.com.fiap.bluepoints.domain.repository.PessoaRepository;
import br.com.fiap.bluepoints.domain.repository.ReciclagemRepository;
import br.com.fiap.bluepoints.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class BluepointsApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ReciclagemRepository reciclagemRepository;

	@Autowired
	private FotoRepository fotoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BluepointsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		criarSistema();
	}

	@Transactional
	public void criarSistema() {
		var qtd = pessoaRepository.count();
		if (qtd > 0) return;

		var matheus = Pessoa.builder()
				.nome("MATHEUS FELIPE")
				.sobrenome("CAMARINHA DUARTE")
				.pontos(50000)
				.build();

		// Salvando a pessoa para garantir que ela esteja gerenciada pelo contexto de persistência
		pessoaRepository.save(matheus);

		var foto1 = Foto.builder()
				.src("TEStE")
				.build();
		fotoRepository.save(foto1); // Salvando a foto para garantir que ela esteja gerenciada

		var reciclagem1 = Reciclagem.builder()
				.pessoa(matheus)
				.foto(foto1)
				.pontos(0)
				.isValidado(false)
				.build();
		reciclagemRepository.save(reciclagem1);

		var usuario1 = Usuario.builder()
				.email("matheus@gmail.com")
				.senha("matheus")
				.pessoa(matheus)
				.build();

		usuarioRepository.save(usuario1);
	}
}
