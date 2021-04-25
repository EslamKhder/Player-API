package com.spring.playerapi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.playerapi.model.Player;


@Repository
public class PlayerDaoImpl implements PlayerDAO {

	
	private SessionFactory sessionFactory;
	
	@Autowired
	public PlayerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public List<Player> getPlayers() {
		// begain 
		Session session = sessionFactory.getCurrentSession();
		
		Query<Player> query = session.createQuery("from Player",Player.class);
		
		// commit
		return query.getResultList();
	}


	@Override
	public void addPlayers(Player player) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(player);
	}


	@Override
	public Player getPlayer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Player.class, id);
	}


	@Override
	public int removePlayer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Player where id=?1");
		q.setInteger(1, id);
		
		return q.executeUpdate();  // 1    0
		
	}
	
}