package com.infostore.dslist.dto;

import com.infostore.dslist.entities.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {		
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName(); 
	}

	
	//Apenas Getters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
