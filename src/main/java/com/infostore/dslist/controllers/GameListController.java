//Esse pacote é a porta de entrada do BackEnd
//Ele irá disponibilizar a nossa API
package com.infostore.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infostore.dslist.dto.GameListDTO;
import com.infostore.dslist.services.GameListService;

@RestController //configura a classe como controller
@RequestMapping(value = "/lists") //criando o mapeamento/ caminho de resposta da API
public class GameListController {
	
	@Autowired //injetando componente. Injeta um Service
	private GameListService gameListService; //instanciando a classe "GameListService"
	
	
	@GetMapping //EndPoint tipo GET
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
