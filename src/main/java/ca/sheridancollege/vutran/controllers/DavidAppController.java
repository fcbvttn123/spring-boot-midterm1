package ca.sheridancollege.vutran.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.vutran.beans.Exercise;
import ca.sheridancollege.vutran.repo.ExerciseRepo;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/exercise")
public class DavidAppController {
	private ExerciseRepo er;
	
	@GetMapping
    public List<Exercise> getAllEx() {
        return er.findAll();
    }
    @GetMapping(value = "{id}") 
    public Exercise getIndividualEx(@PathVariable("id") Long id) {
        return er.findById(id).get();
    }
    @PostMapping(consumes = "application/json")
    public Exercise postEx(@RequestBody Exercise e) {
        return er.save(e);
    }
    @PutMapping(consumes = "application/json")
    public String putExCollection(@RequestBody List<Exercise> aList) {
        er.deleteAll();
        er.saveAll(aList);
        return "Total Records: " + er.count();
    }
    @PutMapping(value = "{id}", consumes = "application/json")
    public List<Exercise> putEx(@RequestBody Exercise e, @PathVariable("id") Long id) {
        er.deleteById(id);
        er.save(e);
        return er.findAll();
    }
    @DeleteMapping(value = "{id}")
    public String deleteEx(@PathVariable("id") Long id) {
        er.deleteById(id);
        return "Deleted id: " + id;
    }
    @DeleteMapping
    public String deleteAll() {
        er.deleteAll();
        return "Deleted All";
    }
}
