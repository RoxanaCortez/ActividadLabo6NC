package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	
	//Método para obtener todos los estudiantes
	@Override
	public List<Estudiante> findAll() throws DataAccessException { 
		StringBuffer sb = new StringBuffer();    //objeto StringBuffer
		sb.append("select * from public.estudiante");	//definiendo consulta
		Query query = entityManager.createNativeQuery(sb.toString(),Estudiante.class);
		List<Estudiante>resulset=query.getResultList();	//obtenemos lista de estudiantes
		return resulset;
	}
	//Método para obtener un estudiante
	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = entityManager.find(Estudiante.class,  code);
		return estudiante;
	}
	
	//Método para insertar un nuevo estudiante
	@Override
	@Transactional
	public void insertar(Estudiante e) throws DataAccessException {
		
		if(e.getCodigo() == null) { //Si llave primaria viene vacío, entonces es un INSERT
			entityManager.persist(e); //Utilizamos persist
		}
		else { //Caso contrario, se buscó al estudiante
			entityManager.merge(e); //Utilizamos merge ya que es un UPDATE
		}
		
	}
	
	//Método para eliminar un estudiante
	@Override
	@Transactional
	public int eliminar(Integer c) throws DataAccessException {
		// TODO Auto-generated method stub
		try{
			StringBuffer sb= new StringBuffer();
			sb.append("delete from public.estudiante where c_usuario=:c");
			Query query = entityManager.createNativeQuery(sb.toString(),Estudiante.class);
			query.setParameter("c", c);
			query.executeUpdate();
			 return 1;
		} catch(Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}

}
