package com.rdsWebExample.repository;

import java.util.Map;

import com.rdsWebExample.entities.Vehicle;

public interface IRedisRepositoryVehicle {
	Map<String,Vehicle> findAll();//estructura de datos clave valor
	Vehicle findById(String id);
	void save(Vehicle vehicle);
	void delete(String id);
}
