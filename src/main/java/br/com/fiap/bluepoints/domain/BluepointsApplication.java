package br.com.fiap.bluepoints.domain;

import br.com.fiap.bluepoints.domain.entity.Foto;
import br.com.fiap.bluepoints.domain.entity.Pessoa;
import br.com.fiap.bluepoints.domain.entity.Reciclagem;
import br.com.fiap.bluepoints.domain.entity.Usuario;
import br.com.fiap.bluepoints.domain.repository.ReciclagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class BluepointsApplication implements CommandLineRunner {

    @Autowired
    private ReciclagemRepository reciclagemRepository;


    public static void main(String[] args) {
        SpringApplication.run(BluepointsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Collection<Reciclagem> reciclagens = criarSistema();
        reciclagens.forEach(System.out::println);
    }

    @Transactional
    public Collection<Reciclagem> criarSistema() {
        var qtd = reciclagemRepository.count();
        if (qtd > 0) return null;

        var matheus = Pessoa.builder()
                .nome("MATHEUS FELIPE")
                .sobrenome("CAMARINHA DUARTE")
                .pontos(50000)
                .build();

        var foto1 = Foto.builder()
                .src("teste/foto1.jpg")
                .build();

        var foto2 = Foto.builder()
                .src("teste/foto2.jpg")
                .build();

        var foto3 = Foto.builder()
                .src("teste/foto3.jpg")
                .build();

        var usuario1 = Usuario.builder()
                .email("matheus@gmail.com")
                .senha("matheus")
                .pessoa(matheus)
                .build();


        var reciclagem1 = Reciclagem.builder()
                .usuario(usuario1)
                .isValidado(false)
                .foto(foto1)
                .pontos(0)
                .momento(LocalDateTime.now().minusMinutes(1))
                .build();


        var reciclagem2 = Reciclagem.builder()
                .usuario(usuario1)
                .isValidado(false)
                .foto(foto2)
                .momento(LocalDateTime.now().plusMinutes(1))
                .pontos(10)
                .build();

        var reciclagem3 = Reciclagem.builder()
                .usuario(usuario1)
                .isValidado(false)
                .foto(foto3)
                .momento(LocalDateTime.now().plusMinutes(2))
                .pontos(30)
                .build();

        var reciclagens = Arrays.asList(reciclagem1, reciclagem2, reciclagem3);

        reciclagemRepository.saveAll(reciclagens);

        return reciclagens;
    }
}
