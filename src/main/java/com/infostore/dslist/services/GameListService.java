/*Pacote que implementa regras de négocio*/
package com.infostore.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infostore.dslist.dto.GameListDTO;
import com.infostore.dslist.entities.GameList;
import com.infostore.dslist.repositories.GameListRepository;

@Service //Registra como um componente do sistema
public class GameListService {
	
	@Autowired //injetando componente. Injeta um "Repository"
	private GameListRepository gameListRepository; //instanciando a classe "GameRepository"	
	
	//método busca todos
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList(); //Cria uma lista a partir da GameList
		 
	}
}
