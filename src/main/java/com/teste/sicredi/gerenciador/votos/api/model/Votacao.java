package com.teste.sicredi.gerenciador.votos.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.sicredi.gerenciador.votos.api.enums.StatusVotacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "TB_VOTACAO")
@Entity
@AllArgsConstructor
public class Votacao {
	
	@SuppressWarnings("unused")
	private Votacao() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_VOTACAO")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ID_PAUTA")
	private Pauta pauta;
	
	@Column(name = "STATUS", nullable = false)
	private StatusVotacao status;
		
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "DT_INICIO", nullable = false)
	private LocalDateTime dataInicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "DT_FIM", nullable = false)
	private LocalDateTime dataFim;
}
