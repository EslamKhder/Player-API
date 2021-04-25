package com.spring.playerapi.service;

import java.util.List;

import com.spring.playerapi.model.Player;
public interface PlayerService {

	public List<Player> allPlayers();
	
	public void savePlayer(Player player);
	
	public Player showPlayer(int id);
	
	public int deletePlayer(int id);
}
