package com.infostore.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Configura minha classe para ela se tornar equivalente a uma tabela do DB relacional
@Table(name = "tb_game_list")
public class GameList {
	//Atributos
	@Id //define "id" como chave primária no DB
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gera o auto increment
	private Long id;
	private String name;
	
	//Construtores
	public GameList() {		
	}

	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	
	//Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	//Comparar dois Games - Opção: Source-> Generate hashCode() and equals()..
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}	
	
	
}
