package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
//import lombok.*;
//import java.util.Date;
import br.ufscar.dc.dsw.validation.UniqueCPF;

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
//@NoArgsConstructor @AllArgsConstructor 
public class Usuario extends AbstractEntity<Long> {
  
	//Atributos comuns a todos os usuarios
	@NotBlank
    @Column(nullable = false, length = 20, unique = true)
    //@Getter @Setter 
    private String username;
    
	@NotBlank
    @Column(nullable = false, length = 64)
    //@Getter @Setter 
    private String password;
       
    @NotBlank
    @Column(nullable = false, length = 60)
    //@Getter @Setter 
    private String nome;

	@NotBlank
    @Column(nullable = false, length = 10)
    //@Getter @Setter 
    private String role;

    @Column(nullable = false)
    //@Getter @Setter 
    private boolean enabled;


    //Atributos para cliente
	//@UniqueCPF (message = "{Unique.usuario.CPF}")
    @NotBlank
    @Column(nullable = true, length = 14, unique = true)
    //@Getter @Setter 
    private String CPF;

	@NotBlank
    @Column(nullable = true, length = 14)
    //@Getter @Setter 
    private String telefone;

	@NotBlank
    @Column(nullable = true, length = 1)
    //@Getter @Setter 
    private String sexo;

	
    @Column(nullable = true)
    //@Getter @Setter 
    private String dataNascimento;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}