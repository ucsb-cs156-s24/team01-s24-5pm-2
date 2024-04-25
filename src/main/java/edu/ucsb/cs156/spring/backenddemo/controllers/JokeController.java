package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucsb.cs156.spring.backenddemo.services.JokeQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Jokes from from https://v2.jokeapi.dev")
@RestController
@RequestMapping("/api/joke")
public class JokeController {
    
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    JokeQueryService jokeQueryService;
    //String.valueOf(numJokes)
    @Operation(summary = "Get a number of english joke from a specific category")
    @GetMapping("/get")
    public ResponseEntity<String> getJokes(
        @Parameter(name="category", description= "requested category", example = "Programming") @RequestParam String category,
        @Parameter(name="numJokes", description= "requested number of jokes", example = "2") @RequestParam int numJokes
        ) throws JsonProcessingException {
            
            String result = jokeQueryService.getJSON(category,numJokes);
            return ResponseEntity.ok().body(result);
    }

}