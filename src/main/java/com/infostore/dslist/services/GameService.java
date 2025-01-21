package com.infostore.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infostore.dslist.dto.GameMinDTO;
import com.infostore.dslist.entities.Game;
import com.infostore.dslist.repositories.GameRepository;

@Service //Registra como um componente do sistema
public class GameService {
	
	@Autowired //injetando componente. Injeta um "Repository"
	private GameRepository gameRepository; //instanciando a classe "GameRepository"
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList(); //Cria uma lista a partir da lista geral
		 
	}
}
