package com.loadsapi.loadsapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loadsapi.loadsapi.entities.Load;
import com.loadsapi.loadsapi.repository.LoadsRepository;

// Implementation of LoadService for managing Load entities.
@Service
public class LoadServiceImpl implements LoadService {
    
    @Autowired
    private LoadsRepository loadsRepository;

    // Retrieve all Load entities from the repository.
    @Override
    public List<Load> getAllLoads() {
        return loadsRepository.findAll();
    } 
    
    // Retrieve a list of Load entities filtered by the specified shipper ID.
    @Override
    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadsRepository.findByShipperId(shipperId);
    }
    
    // Retrieve a Load entity by its ID.
    @Override
    public Load getLoadByLoadId(long loadId) {
        Optional<Load> optionalLoad = loadsRepository.findById(loadId);
        
        //Handling load not found
        if(optionalLoad.isPresent()) {
            return optionalLoad.get();
        } else {
            throw new RuntimeException("Load not found for id: " + loadId);
        }
    }


    // Add a new Load entity to the repository
    @Override
    public String addLoad(Load load) {
        loadsRepository.save(load);
        return "Load details added successfully";
    }
    
    // Update an existing Load entity identified by its ID.
    @Override
    public void updateLoad(long loadId, Load load) {
        Optional<Load> optionalExistingLoad = loadsRepository.findById(loadId);
        
        if (optionalExistingLoad.isPresent()) {
            Load existingLoad = optionalExistingLoad.get();
            
            existingLoad.setLoadingPoint(load.getLoadingPoint());
            existingLoad.setUnloadingPoint(load.getUnloadingPoint());
            existingLoad.setProductType(load.getProductType());
            existingLoad.setTruckType(load.getTruckType());
            existingLoad.setNoOfTrucks(load.getNoOfTrucks());
            existingLoad.setWeight(load.getWeight());
            existingLoad.setComment(load.getComment());
            existingLoad.setDate(load.getDate());
            existingLoad.setShipperId(load.getShipperId());

            loadsRepository.save(existingLoad);
        } else {
            throw new RuntimeException("Load not found with id: " + load.getLoadId());
        }
    }
    
    //Delete a Load entity identified by its ID.
    @Override
    public void deleteLoad(long loadId) {
        loadsRepository.deleteById(loadId);
    }
}
