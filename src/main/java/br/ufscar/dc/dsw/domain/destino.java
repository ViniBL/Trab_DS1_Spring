package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@surpresswarnings("serial")
@Entity
@Table(name = "destino")
public class destino extends AbstractEntity<Long> {
    @NotBlank(message = "{NotBlank.destino.cidade}")
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String cidade;

    @NotBlank(message = "{NotBlank.destino.estado}")
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String estado;

    @NotBlank(message = "{NotBlank.destino.pais}")
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String pais;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
