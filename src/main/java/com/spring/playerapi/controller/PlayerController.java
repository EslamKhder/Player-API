package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.exception.StudentException;
import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;


// http://localhost:8080/spring-crm-rest
@RestController
@RequestMapping("/api")
// http://localhost:8080/spring-crm-rest/api
public class PlayerController {
	
	
	@Autowired
	private PlayerService playerService;
	
	
	
	@GetMapping("/data")
	// http://localhost:8080/spring-crm-rest/api/data
	public String getData() {
		return "mydata";
	}
	
	// http://localhost:8080/spring-crm-rest/api/players
	@GetMapping("/players")
	public List<Player> getPlayers(){
		return playerService.allPlayers();
	}
	
	
	// http://localhost:8080/spring-crm-rest/api/players/id
	@GetMapping("/players/{id}")
	public Player getPlayerById(@PathVariable("id")int id) {
		Player p = playerService.showPlayer(id);
		if(p == null) {
			throw new StudentException("Player Not Found id: " + id);
		}
		return p;
	}
	
	// http://localhost:8080/spring-crm-rest/api/players
	/*@GetMapping("/players")
	public Player getPlayerById(@RequestParam int id) {
		return playerService.showPlayer(id);
	}*/
	
}
