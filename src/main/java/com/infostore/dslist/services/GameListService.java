/*Pacote que implementa regras de négocio*/
package com.infostore.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infostore.dslist.dto.GameListDTO;
import com.infostore.dslist.entities.GameList;
import com.infostore.dslist.projections.GameMinProjection;
import com.infostore.dslist.repositories.GameListRepository;
import com.infostore.dslist.repositories.GameRepository;

@Service //Registra como um componente do sistema
public class GameListService {
	
	@Autowired //injetando componente. Injeta um "Repository"
	private GameListRepository gameListRepository; //instanciando a classe "GameRepository"	
	
	@Autowired
	private GameRepository gameRepository;
	
	//método busca todos
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList(); //Cria uma lista a partir da GameList
		 
	}
	
	@Transactional(readOnly = true)
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId); //busco a lista
		GameMinProjection obj = list.remove(sourceIndex); //excluo da lista
		list.add(destinationIndex, obj); //adiciono na nova posição
		
		//Ternário
		//se sourceIndex for menor destinationIndex, então(?) "sourceIndex" é o 'min', senão (:) o 'min' é "destinationIndex"
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++ ) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
