package com.gmm.service;

//Author: Muthu Mariyappan G

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmm.entities.GamesMapper;
import com.gmm.entities.Games;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GamesMapper gamesMapper;

	@Override
	public Games findByName(String name) {

		return gamesMapper.findByName(name);
	}

	@Override
	public Games findById(Integer id) {

		return gamesMapper.findById(id);
	}

	@Override
	public List<Games> findAll() {

		return gamesMapper.findAll();
	}
}
