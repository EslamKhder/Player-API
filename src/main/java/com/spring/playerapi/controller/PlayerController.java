package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		Player p = playerService.showPlayer(id); //  //
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
	
	// http://localhost:8080/spring-crm-rest/api/players
	@PostMapping("/players")
	public String savaPlayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Success Added";
	}
	
	// http://localhost:8080/spring-crm-rest/api/players
	@PutMapping("/players")
	public String editPlayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Success editing";
	}
	
	// http://localhost:8080/spring-crm-rest/api/players/id
	@DeleteMapping("/players/{id}")
	public void removePlayer(@PathVariable("id")int id) {
		int result = playerService.deletePlayer(id);
		System.out.println(result);
		if(result == 0) {
			throw new StudentException("Player Not Found id: " + id);
		}
			
		
	}
	// http://localhost:8080/spring-crm-rest/api/players
	/*@DeleteMapping("/players")
	public void removePlayer(@RequestParam int id) {
		playerService.deletePlayer(id);
	}*/
		
}
