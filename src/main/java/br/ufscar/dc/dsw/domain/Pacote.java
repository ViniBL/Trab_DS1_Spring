package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import java.util.Date;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Pacote")
@NoArgsConstructor @AllArgsConstructor 
public class Pacote extends AbstractEntity<Long> {

	@NotNull(message = "{NotNull.pacote.data_partida}")
	@Column(nullable = false)
	@Getter @Setter private Date data_partida;

	@NotNull(message = "{NotNull.pacote.duracao}")
	@Column(nullable = false)
	@Getter @Setter private int duracao;

	@NotNull
	@Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	@Getter @Setter private BigDecimal valor;

	@NotBlank(message = "{NotBlank.pacote.descricao}")
	@Size(max = 256)
	@Column(nullable = false, length = 256)
	@Getter @Setter private String descricao;

	@ManyToOne
	@JoinColumn(name = "agencia_id")
	@Getter @Setter private Agencia agencia;

	@NotBlank(message = "{NotBlank.destino.cidade}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	@Getter @Setter private String cidade;

	@NotBlank(message = "{NotBlank.destino.estado}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	@Getter @Setter private String estado;

	@NotBlank(message = "{NotBlank.destino.pais}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	@Getter @Setter private String pais;
}
