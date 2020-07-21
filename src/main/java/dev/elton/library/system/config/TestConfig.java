package dev.elton.library.system.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.elton.library.system.entities.Cliente;
import dev.elton.library.system.entities.Livro;
import dev.elton.library.system.repositories.ClienteRepository;
import dev.elton.library.system.repositories.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//database seeding
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Kezia Soares", "kezia@gmail.com");
		Cliente c2 = new Cliente(null, "Elton Araujo", "elton.araujo@gmail.com");
		
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		
		Livro l1 = new Livro(null, "O Senhor dos Aneis - A sociedade do Anel", "JRR Tolkien", "Lorem ipsum", "Balrog", "1995");
		Livro l2 = new Livro(null, "O senhor dos Aneis - As Duas Torres", "JRR Tolkien", "Lorem ipsum a", "Balrog", "1996");
		
		livroRepository.saveAll(Arrays.asList(l1,l2));
		
		
		
	}
	
	

}
