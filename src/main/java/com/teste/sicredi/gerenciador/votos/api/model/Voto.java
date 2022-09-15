package com.teste.sicredi.gerenciador.votos.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.teste.sicredi.gerenciador.votos.api.enums.VotoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "TB_VOTO")
@Entity
@AllArgsConstructor
public class Voto {
	
	@SuppressWarnings("unused")
	private Voto() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_VOTO")
	private Long id;
	
	@Column(name = "CPF", nullable = false)
	private String cpf;
	
	@Column(name = "VOTO", nullable = false)
	private VotoEnum voto;

	@OneToOne
	@JoinColumn(name = "ID_VOTACAO")
	private Votacao votacao;
}
