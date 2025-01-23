/*Pacote que implementa regras de négocio*/
package com.infostore.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infostore.dslist.dto.GameDTO;
import com.infostore.dslist.dto.GameMinDTO;
import com.infostore.dslist.entities.Game;
import com.infostore.dslist.projections.GameMinProjection;
import com.infostore.dslist.repositories.GameRepository;

@Service //Registra como um componente do sistema
public class GameService {
	
	@Autowired //injetando componente. Injeta um "Repository"
	private GameRepository gameRepository; //instanciando a classe "GameRepository"
	
	//método de busca por Id
	@Transactional(readOnly = true) //defino que será feito apenas leitura. deixará o DB mais rápido
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		//GameDTO dto = new GameDTO(result);
		//return dto;
		return new GameDTO(result);
		
	}	
	
	//método busca todos
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList(); //Cria uma mini lista a partir da lista geral		 
	}
	
	//método busca por lista
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();	 
	}
}
