package com.example.VehicleService.Controller;

import com.example.VehicleService.Entity.Vehicle;
import com.example.VehicleService.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {



    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/serviceYear/{serviceYear}")
    public List<Vehicle> getVehiclesByServiceYear(@PathVariable int serviceYear) {
        return vehicleRepository.findByServiceYear(serviceYear);
    }

    @GetMapping("/serviceId/{serviceId}")
    public String getVehicleTypeByServiceId(@PathVariable long serviceId){
        String vehicleType = vehicleRepository.findByServiceId(serviceId);
        if(vehicleType != null){
            return vehicleType;
        } else {
            return "Vehicle Type not found for service ID = " + serviceId;
        }
    }

    @DeleteMapping("/delete/{serviceYear}")
    public String deleteByServiceYear(@PathVariable int serviceYear){
        vehicleRepository.deleteByServiceYear(serviceYear);
        return "All the records of Year "+ serviceYear +" has been deleted!";
    }

}
