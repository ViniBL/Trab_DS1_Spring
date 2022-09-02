package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Pacote_adquirido")
@Check(constraints = "status IN('CANCELADO', 'VIGENTE')")
@NoArgsConstructor @AllArgsConstructor 
public class Pacote_adquirido extends AbstractEntity<Long> {
    /*
	@NotNull
	@Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	@Getter @Setter private BigDecimal valor;
	*/

	@NotBlank
    @Column(nullable = false, length = 10)
    @Getter @Setter private String status;
    
	@NotNull(message = "{NotNull.pacote_adquirido.pacote}")
	@ManyToOne
	@JoinColumn(name = "pacote_id")
	@Getter @Setter private Pacote pacote;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@Getter @Setter private Usuario usuario;

}
