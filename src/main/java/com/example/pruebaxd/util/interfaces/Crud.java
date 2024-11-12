package com.example.pruebaxd.util.interfaces;

import java.util.List;

import java.util.Optional; 

public interface Crud<T, ID> {
	List<T> listar();

	Optional<T> buscarPorId(ID id);

	T guardar(T request)  ;

	boolean existePorId(ID id);

	void eliminarPorId(ID id);

}