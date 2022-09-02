package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
@Check(constraints = "sexo IN('M', 'F', 'N')")
@Check(constraints = "role IN('ADM', 'USER', 'AGENCIA')")
@NoArgsConstructor @AllArgsConstructor 
public class Usuario extends AbstractEntity<Long> {
  
	//Atributos comuns a todos os usuarios
	@NotBlank
    @Column(nullable = false, length = 20, unique = true)
    @Getter @Setter private String username;
    
	@NotBlank
    @Column(nullable = false, length = 64)
    @Getter @Setter private String password;
       
    @NotBlank
    @Column(nullable = false, length = 60)
    @Getter @Setter private String nome;

	@NotBlank
    @Column(nullable = false, length = 10)
    @Getter @Setter private String role;

    @Column(nullable = false)
    @Getter @Setter private boolean enabled;


    //Atributos para cliente
	@UniqueCPF (message = "{Unique.usuario.CPF}")
    @NotBlank
    @Column(nullable = true, length = 14, unique = true)
    @Getter @Setter private String CPF;

	@NotBlank
    @Column(nullable = true, length = 14)
    @Getter @Setter private String telefone;

	@NotBlank
    @Column(nullable = true, length = 1)
    @Getter @Setter private String sexo;

	@NotBlank
    @Column(nullable = true, length = 10)
    @Getter @Setter private Date dataNascimento;


	//Atributos para agencia
	@UniqueCNPJ (message = "{Unique.usuario.CNPJ}")
	@Size(min = 18, max = 18, message = "{Size.usuario.CNPJ}")
	@Column(nullable = true, unique = true, length = 60)
	@Getter @Setter private String CNPJ;

	@Size(min = 0, max = 256)
	@Column(nullable = true, unique = false, length = 256)
	@Getter @Setter private String descricao;
		
	
}