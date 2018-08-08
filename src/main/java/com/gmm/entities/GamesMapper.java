package com.gmm.entities;

//Author: Muthu Mariyappan G

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface GamesMapper {

	public Games findByName(@Param("name") String name);

	public Games findById(@Param("id") Integer id);

	public List<Games> findAll();

}
