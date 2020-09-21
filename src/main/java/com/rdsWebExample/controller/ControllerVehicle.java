package com.rdsWebExample.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rdsWebExample.entities.Vehicle;
import com.rdsWebExample.repository.VehicleRepository;


@RestController
public class ControllerVehicle {
	private VehicleRepository vehicleRepository;
	
	public ControllerVehicle(VehicleRepository vehicleRepository) {
		this.vehicleRepository=vehicleRepository;
	}
	
	@GetMapping("/vehicles")
	public Map<String,Vehicle> findAll(){
		System.out.println("HOLA");
		
		return vehicleRepository.findAll();		
	}
	@GetMapping("/vehicles/{id}")
	public Vehicle findByid(@PathVariable String id) {
		
		
		return vehicleRepository.findById(id);
	}
	@PostMapping("/vehicles")
	public void createVehicle(@RequestBody Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	@DeleteMapping("/vehicles/{id}")
	public void deleteVehicle(@PathVariable String id) {
		vehicleRepository.delete(id);
	}

}
