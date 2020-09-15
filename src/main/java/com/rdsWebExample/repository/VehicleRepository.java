package com.rdsWebExample.repository;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.HashOperations;
import com.rdsWebExample.domain.Vehicle;

public class VehicleRepository implements IRedisRepositoryVehicle {
	private static final String KEY="Vehicle";
	
	private RedisTemplate<String, Vehicle> redisTemplate;//objeto de tipo redis template(conexion con la bd)
	private HashOperations<String, String, Vehicle> hashoperations;//interface que ejecuta las operaciónes por medio del redistemplate
 	
	
	

	public VehicleRepository(RedisTemplate<String, Vehicle> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
	}
	
	@PostConstruct
	private void init() {
		hashoperations=redisTemplate.opsForHash();//permite realizar operaciones en la base de datos
	}

	@Override
	public Map<String, Vehicle> findAll() {
		return hashoperations.entries(KEY);
	}

	@Override
	public Vehicle findById(String id) {
		
		return (Vehicle) hashoperations.get(KEY, id);
	}

	@Override
	public void save(Vehicle vehicle) {
		hashoperations.put(KEY, UUID.randomUUID().toString(),vehicle);	
	}

	@Override
	public void delete(String id) {
		hashoperations.delete(KEY, id);
	}
	

}
