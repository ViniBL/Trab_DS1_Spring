package br.ufscar.dc.dsw.domain;

import java.util.List;

//import lombok.*;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.ufscar.dc.dsw.validation.UniqueCNPJ;

@SuppressWarnings("serial")
@Entity
@Table(name = "Agencia")
//@NoArgsConstructor @AllArgsConstructor 
public class Agencia extends AbstractEntity<Long> {

	@UniqueCNPJ (message = "{Unique.agencia.CNPJ}")
	@NotBlank
	@Size(min = 18, max = 18, message = "{Size.agencia.CNPJ}")
	@Column(nullable = false, unique = true, length = 60)
	//@Getter @Setter 
	private String CNPJ;
	
	@NotBlank
	@Size(min = 3, max = 60)
	@Column(nullable = false, unique = true, length = 60)
	//@Getter @Setter 
	private String nome;

	@NotBlank 
	@Size(min = 0, max = 256)
	@Column(nullable = false, length = 256)
	//@Getter @Setter 
	private String descricao;

	@OneToMany(mappedBy = "agencia")
	//@Getter @Setter 
	private List<Pacote> pacotes;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

}
