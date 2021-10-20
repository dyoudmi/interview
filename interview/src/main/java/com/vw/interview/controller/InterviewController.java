package com.vw.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vw.interview.exception.ResourceNotFoundException;
import com.vw.interview.model.Unicorn;
import com.vw.interview.repo.UnicornRepository;

@RestController
public class InterviewController {
	
	@Autowired
    private UnicornRepository unicornRepository;
	
	@GetMapping("/unicorns")
    public List <Unicorn> getUnicorns() {
        return unicornRepository.findAll();
    }

    @GetMapping("/unicorns/{unicornId}")
    public ResponseEntity<Unicorn> getUnicornById(@PathVariable(value = "unicornId") Long unicornId)
    		throws ResourceNotFoundException {
        Unicorn unicorn = unicornRepository.findById(unicornId)
        		.orElseThrow(() -> new ResourceNotFoundException("Unicorn not found for this id :: " + unicornId));
        return ResponseEntity.ok().body(unicorn);
    }

    @PostMapping("/unicorns")
    public Unicorn createUnicorn(@RequestBody Unicorn unicorn) {
        return unicornRepository.save(unicorn);
    }

    @PutMapping("/unicorns/{unicornId}")
    public ResponseEntity <Unicorn> updateUnicorn(@PathVariable(value = "unicornId") Long unicornId,
    		@RequestBody Unicorn unicornDetails) throws ResourceNotFoundException {
    	Unicorn unicorn = unicornRepository.findById(unicornId)
    			.orElseThrow(() -> new ResourceNotFoundException("Unicorn not found for this id :: " + unicornId));

        unicorn.setName(unicornDetails.getName());
        unicorn.setEyeColor(unicornDetails.getEyeColor());
        unicorn.setHairColor(unicornDetails.getHairColor());
        unicorn.setHeight(unicornDetails.getHeight());
        unicorn.setHeightUnit(unicornDetails.getHeightUnit());
        unicorn.setHornColor(unicornDetails.getHornColor());
        unicorn.setHornLength(unicornDetails.getHornLength());
        unicorn.setWeight(unicornDetails.getWeight());
        unicorn.setWeightUnit(unicornDetails.getWeightUnit());
        final Unicorn updatedUnicorn = unicornRepository.save(unicorn);
        return ResponseEntity.ok(updatedUnicorn);
    }
}
