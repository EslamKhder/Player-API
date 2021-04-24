package com.spring.playerapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.playerapi.dao.PlayerDAO;
import com.spring.playerapi.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDao;
	
	
	public PlayerServiceImpl() {
	}

	@Override
	@Transactional
	public List<Player> allPlayers() {
		// begain
		return playerDao.getPlayers();
		// commit
	}

	@Override
	@Transactional
	public void savePlayer(Player player) {
		playerDao.addPlayers(player);
	}

	@Override
	@Transactional
	public Player showPlayer(int id) {
		return playerDao.getPlayer(id);
	}

	@Override
	@Transactional
	public void deletePlayer(int id) {
		// TODO Auto-generated method stub
		playerDao.removePlayer(id);
		
	}

}
