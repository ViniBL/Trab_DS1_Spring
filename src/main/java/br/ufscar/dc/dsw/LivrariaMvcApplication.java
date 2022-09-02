package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IAgenciaDAO;
import br.ufscar.dc.dsw.dao.IPacoteDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class LivrariaMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IAgenciaDAO agenciaDAO, IPacoteDAO pacoteDAO) {
		return (args) -> {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			
			Usuario u1 = new Usuario();
			u1.setLogin("admin");
			u1.setPassword.encode("admin");
			u1.setCPF("012.345.678-90");
			u1.setNome("Administrador");
			u1.setRole("ADM");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setLogin("beltrano");
			u2.setPassword(encoder.encode("123"));
			u2.setCPF("985.849.614-10");
			u2.setNome("Beltrano Andrade");
			u2.setRole("USER");
			u2.setEnabled(true);
			u2.setTelefone("31-99990-9090");
			u2.setSexo("M");
			Date data = formato.parse(10/02/1999); 
			u2.setDataNascimento(data);
			usuarioDAO.save(u2);
			
			Usuario u3 = new Usuario();
			u3.setLogin("fulana");
			u3.setPassword(encoder.encode("123"));
			u3.setCPF("367.318.380-04");
			u3.setNome("Fulana Silva");
			u3.setRole("USER");
			u3.setTelefone("31-99990-9091");
			u3.setSexo("F");
			Date data = formato.parse(17/12/1993); 
			u3.setDataNascimento(data);
			u3.setEnabled(true);
			usuarioDAO.save(u3);
			
			Agencia e1 = new Agencia();
			e1.setCNPJ("55.789.390/0008-99");
			e1.setNome("Companhia Aéria");
			e1.setDescricao("Viagens de avião");
			agenciaDAO.save(e1);
			
			Agencia e2 = new Agencia();
			e2.setCNPJ("71.150.470/0001-40");
			e2.setNome("Companhia Ferroviária");
			e2.setDescricao("Viagens de trem");
			agenciaDAO.save(e2);
			
			Agencia e3 = new Agencia();
			e3.setCNPJ("32.106.536/0001-82");
			e3.setNome("Companhia Marítima");
			e3.setDescricao("Viagens de canoa");
			agenciaDAO.save(e3);
			
			Pacote l1 = new Pacote();
			l1.setDescricao("Primeira classe");
			l1.setCidade("Florianópolis");
			l1.setEstado("SC");
			l1.setPais("Brasil");
			l1.setDuracao(2);
			l1.setValor(BigDecimal.valueOf(1300.9));
			l1.setAgencia(e1);
			Date data = formato.parse(17/12/2022); 
			l1.setData_partida(data);
			pacoteDAO.save(l1);
			
			Pacote l2 = new Pacote();
			l2.setDescricao("Maria Fumaça");
			l2.setCidade("Ouro Preto");
			l2.setEstado("MG");
			l2.setPais("Brasil");
			l2.setDuracao(6);
			l2.setValor(BigDecimal.valueOf(45.4));
			l2.setAgencia(e2);
			Date data = formato.parse(17/12/2022); 
			l2.setData_partida(data);
			pacoteDAO.save(l2);
			
			Pacote l3 = new Pacote();
			l3.setDescricao("Vai ter que remar");
			l3.setCidade("Japiim");
			l3.setEstado("AM");
			l3.setPais("Brasil");
			l3.setDuracao(2);
			l3.setValor(BigDecimal.valueOf(10.0));
			l3.setAgencia(e3);
			Date data = formato.parse(17/12/2022); 
			l3.setData_partida(data);
			pacoteDAO.save(l3);
		};
	}
}
