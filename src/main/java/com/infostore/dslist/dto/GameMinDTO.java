package com.infostore.dslist.dto;

import com.infostore.dslist.entities.Game;

public class GameMinDTO {
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO() {
	}

	// buscarei os dados a partir da Entidade (Objeto/ Classe "Game" Novo Objeto "entity")
	public GameMinDTO(Game entity) {
		// posso retirar o "this" pois os valores após o '=' são diferentes
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	//Não precisa de Setters, pois farei apenas busca
	//Getters e Setters
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
}
