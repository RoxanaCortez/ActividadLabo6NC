package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteDAO {
	public List<Estudiante>findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	void insertar(Estudiante e) throws DataAccessException;
	
	int eliminar(Integer c) throws DataAccessException;
	
}
