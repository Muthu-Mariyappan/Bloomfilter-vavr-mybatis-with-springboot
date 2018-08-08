package com.gmm.base.rest;

//Author: Muthu Mariyappan G

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmm.entities.Games;
import com.gmm.service.GameService;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import io.vavr.control.Option; // Vavr Option to handle null values

@RestController
public class BloomfilterVavrMybatisApplicationController {

	@Autowired
	private GameService gameService;
	BloomFilter<Integer> idFilter; // Bloom filter to hold ids
	BloomFilter<String> nameFilter; // Bloom filter to hold names

	public BloomfilterVavrMybatisApplicationController() {
		buildBloomFilters();
	}

	private void buildBloomFilters() { // creating bloomfilters with max of 10 values with 0.01 error rate
		this.nameFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 10, 0.01);
		this.idFilter = BloomFilter.create(Funnels.integerFunnel(), 10, 0.01);
		/* The bloom filter can be constructed from seperate connection to database or from file
		 * Here, for simplicity, the values are hard feeded to the filter
		 * */
		this.nameFilter.put("skyrim".toUpperCase());this.idFilter.put(1);
		this.nameFilter.put("Dota 2".toUpperCase());this.idFilter.put(2);
		this.nameFilter.put("Injustice 2".toUpperCase());this.idFilter.put(3);
		this.nameFilter.put("Final fantasy xv".toUpperCase());this.idFilter.put(4);
		this.nameFilter.put("warcraft 3".toUpperCase());this.idFilter.put(5);
		this.nameFilter.put("claw".toUpperCase());this.idFilter.put(6);
	}
	
	@RequestMapping(value = "/Games/findById/{id}")
	public Map<String, String> findById(@PathVariable Integer id) {
		// @PathVariable takes the part of url as value here {id} taken as id value
		Map<String, String> message = new LinkedHashMap<>(); // to store Games details
		Games foundGames;
		if (this.idFilter.mightContain(id)) { //checking for negatives in bloom filter
			Option<Games> option = Option.of(gameService.findById(id)); // Using vavr option
			if (option.isDefined()) { // returns true if option has Some false if None
				foundGames = option.get(); // gets games object from option wrapper
				// Getting Games detail with help of getter methods
				message.put("ID", foundGames.getId().toString());
				message.put("Name", foundGames.getName());
				message.put("Price", foundGames.getPrice().toString());

			}
		} else {
			message.put("Error", "Cannot find game with id " + id);
		}
		return message;
	}

	@RequestMapping(value = "/Games/findByName/{name}")
	public Map<String, String> findByName(@PathVariable String name) {

		Map<String, String> message = new LinkedHashMap<>();
		Games foundGames;
		if (this.nameFilter.mightContain(name.toUpperCase())) {
			Option<Games> option = Option.of(gameService.findByName(name));
			if (option.isDefined()) {
				foundGames = option.get();
				message.put("ID", foundGames.getId().toString());
				message.put("Name", foundGames.getName());
				message.put("Price", foundGames.getPrice().toString());

			}
		} else {
			message.put("Error", "Cannot find game with name " + name);
		}
		return message;
	}
	
	
	
	/*
	@RequestMapping(value = "/Games/findAll")
	public List<Map<String, String>> findAll() {
		Map<String, String> message = new LinkedHashMap<>();
		List<Map<String, String>> listOfMessages = new LinkedList<>();
		Games foundGames;
		Iterator<Games> iterator = this.gameService.findAll().iterator(); 
		if (iterator.hasNext()) {
			while (iterator.hasNext()) {
				foundGames = iterator.next();
				message.put("ID", foundGames.getId().toString());
				message.put("Name", foundGames.getName());
				message.put("Price", foundGames.getPrice().toString());
				listOfMessages.add(message);
			}
		} else {
			message = new LinkedHashMap<>();
			message.put("Error", "No students found!");
			listOfMessages.add(message);
		}
		return listOfMessages;
	}
	*/
}