package com.rdsWebExample.Controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rdsWebExample.repository.VehicleRepository;
import com.rdsWebExample.domain.Vehicle;


@RestController
public class ControllerVehicle {
	private VehicleRepository vehicleRepo;

	public ControllerVehicle(VehicleRepository vehicleRepo) {
		super();
		this.vehicleRepo=vehicleRepo;
	}
	
	@GetMapping("/vehicles")
	public Map<String,Vehicle> findAll(){
		return this.vehicleRepo.findAll();		
	}
	@GetMapping("/vehicles/{id}")
	public Vehicle findByid(@PathVariable String id) {
		return this.vehicleRepo.findById(id);
	}
	@PostMapping("/vehicles")
	public void createVehicle(@RequestBody Vehicle vhcl) {
		this.vehicleRepo.save(vhcl);
	}
	@DeleteMapping("/vehicles/{id}")
	public void deleteVehicle(@PathVariable String id) {
		this.vehicleRepo.delete(id);
	}
		

}
