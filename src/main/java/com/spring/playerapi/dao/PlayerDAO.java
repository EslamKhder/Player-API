package com.spring.playerapi.dao;

import java.util.List;

import com.spring.playerapi.model.Player;


public interface PlayerDAO {
	
	public List<Player> getPlayers();
	
	public void addPlayers(Player player);
	
	public Player getPlayer(int id);
	
	public void removePlayer(int id);
}
