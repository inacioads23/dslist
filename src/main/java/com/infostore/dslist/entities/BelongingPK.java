/*Classe que faz a função da tabela união entre Belonging e Game*/
package com.infostore.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable //encapsulando dois atributos em uma só classe
public class BelongingPK {
	
	@ManyToOne // Definindo o tipo de relacionamento
	@JoinColumn(name = "game_id") //Definindo a chave estrangeira
	private Game game;
	
	@ManyToOne // Definindo o tipo de relacionamento
	@JoinColumn(name = "list_id") //Definindo a chave estrangeira
	private GameList list;
	
	
	//Construtores
	public BelongingPK(){		
	}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	
	//Getters e Setters
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	
	//Comparar entre as duas classes - Opção: Source-> Generate hashCode() and equals()..
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
}
