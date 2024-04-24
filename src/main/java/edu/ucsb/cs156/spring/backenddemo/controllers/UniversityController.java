package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucsb.cs156.spring.backenddemo.services.UniversityQueryService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name="Full University Name ")
@Slf4j
@RestController
@RequestMapping("/api/university")
public class UniversityController {

    @Autowired
    UniversityQueryService universityQueryService;

    @Operation(summary = "Get full university names that match with provided string", description = "json")
    @GetMapping("/get")
    public ResponseEntity<String> getUniversities(
        @Parameter(name="name", description="part of a university name to be completed", example="UCS") @RequestParam String name
    ) throws JsonProcessingException {
        log.info("getUniversities: name={}", name);
        String result = universityQueryService.getJSON(name);
        return ResponseEntity.ok().body(result);
    }
    
}
