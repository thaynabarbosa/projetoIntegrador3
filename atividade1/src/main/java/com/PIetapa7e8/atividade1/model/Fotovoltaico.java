package com.PIetapa7e8.atividade1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Fotovoltaico")
public class Fotovoltaico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fabricante;
    private int qtdPlacas;
    private float potPlacas;
    private float potGerador;
    private float potInversor;
    private String tipoTelhado;
    private String concessionaria;

   @ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente clientes;
}
