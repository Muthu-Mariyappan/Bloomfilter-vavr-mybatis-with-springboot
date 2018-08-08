package com.gmm.service;

//Author: Muthu Mariyappan G

import java.util.List;

import com.gmm.entities.Games;


public interface GameService {

	public Games findByName(String name);

	public Games findById(Integer id);

	public List<Games> findAll();

}