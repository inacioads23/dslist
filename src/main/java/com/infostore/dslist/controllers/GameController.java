//Esse pacote é a porta de entrada do BackEnd
//Ele irá disponibilizar a nossa API
package com.infostore.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infostore.dslist.dto.GameMinDTO;
import com.infostore.dslist.services.GameService;

@RestController //configura a classe como controller
@RequestMapping(value = "/games") //criando o mapeamento/ caminho de resposta da API
public class GameController {
	
	@Autowired //injetando componente. Injeta um Service
	private GameService gameService; //instanciando a classe "GameService"
	
	@GetMapping //EndPoint tipo GET
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
}
