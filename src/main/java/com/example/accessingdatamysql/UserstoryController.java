package com.example.accessingdatamysql;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserstoryController {
	@Autowired
	UserstoryRepository userstoryRepository;

// Get All userstory
    @GetMapping("/userstory")
    public List<Userstory> getAllUserstory() {
        return (List<Userstory>) userstoryRepository.findAll();
    }
    
 // Create a new userstory
    @PostMapping("/userstory")
    public Userstory createUserstory(@Valid @RequestBody Userstory userstory) {
        return userstoryRepository.save(userstory);
    }
    
 // Get a Single userstory
    @GetMapping("/userstory/{id}")
    public Userstory getUserstoryById(@PathVariable(value = "id") Long UserstoryId) throws UserstoryNotFoundException {
        return userstoryRepository.findById(UserstoryId)
                .orElseThrow(() -> new UserstoryNotFoundException(UserstoryId));
    }
    
  //Update a userstory
    @PutMapping("/userstory/{id}")
    public Userstory updateUserstory(@PathVariable(value = "id") Long UserstoryId,
                           @Valid @RequestBody Userstory userstoryDetails) throws UserstoryNotFoundException {

Userstory userstory = userstoryRepository.findById(UserstoryId)
                .orElseThrow(() -> new UserstoryNotFoundException(UserstoryId));


userstory.setTitle(userstoryDetails.getTitle());
userstory.setAssignedTo(userstoryDetails.getAssignedTo());
userstory.setDate(userstoryDetails.getDate());
userstory.setDescription(userstoryDetails.getDescription());
userstory.setState(userstoryDetails.getState());

Userstory updatedUserstory = userstoryRepository.save(userstory);

return updatedUserstory;
    }
 // Delete a Userstory
    @DeleteMapping("/userstory/{id}")
    public ResponseEntity<?> deleteUserstory(@PathVariable(value = "id") Long userstoryId) throws UserstoryNotFoundException {
        Userstory userstory = userstoryRepository.findById(userstoryId)
                .orElseThrow(() -> new UserstoryNotFoundException(userstoryId));

        userstoryRepository.delete(userstory);

return ResponseEntity.ok().build();
    }

}
