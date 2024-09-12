package com.loadsapi.loadsapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loadsapi.loadsapi.entities.Load;
import com.loadsapi.loadsapi.services.LoadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


// REST Controller for handling operations related to Load entities.
@RestController
public class LoadController {

    @Autowired
    private LoadService loadService;

    //Get a list of all loads
    @GetMapping("/loads")
    public List<Load> getAllLoads() {
        return this.loadService.getAllLoads();
    }

    //Get list of loads with specified shipper id
    @GetMapping("/load")
    public List<Load> getLoadsByShipperId(@RequestParam("shipperId") String shipperId) {
        return this.loadService.getLoadsByShipperId(UUID.fromString(shipperId));
    }

    //Get load with specified load id
    @GetMapping("/load/{loadId}")
    public Load getLoadByLoadId(@PathVariable String loadId) {
        return this.loadService.getLoadByLoadId(Long.parseLong(loadId));
    }

    //Add a new load
    @PostMapping("/load")
    public String addLoad(@RequestBody Load load) {
        return this.loadService.addLoad(load);
    }
    

    //Update load with specified load id
    @PutMapping("load/{loadId}")
    public ResponseEntity<HttpStatus> updateLoad(@PathVariable String loadId, @RequestBody Load load) {
        try {
            this.loadService.updateLoad(Long.parseLong(loadId), load);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete or Remove load with specified load id
    @DeleteMapping("load/{loadId}")
    public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String loadId) {
        try {
            this.loadService.deleteLoad(Long.parseLong(loadId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
