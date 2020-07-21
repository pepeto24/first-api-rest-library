package dev.elton.library.system.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.elton.library.system.entities.Cliente;
import dev.elton.library.system.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//database seeding
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Kezia Soares", "kezia@gmail.com");
		Cliente c2 = new Cliente(null, "Elton Araujo", "elton.araujo@gmail.com");
		
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		
	}
	
	

}
