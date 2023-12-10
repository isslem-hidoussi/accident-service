package com.isslem.accidentservice.controller;

import com.isslem.accidentservice.model.Accident;
import com.isslem.accidentservice.service.AccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accident")
@RequiredArgsConstructor
public class Accidentcontroller {
    private final AccidentService accidentService;
    @GetMapping("/{id}")
    public ResponseEntity<Accident> getAccident(@PathVariable("id") Long id){
        Optional<Accident> accident= accidentService.getAccident(id);
        if (accident.isPresent()) {
            return new ResponseEntity<>(accident.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/all")

    public ResponseEntity<List<Accident>> getAllAccident(){
      List<Accident> accidents= accidentService.getAllAccident();
        return new ResponseEntity<>(accidents,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")

    public ResponseEntity deleteAccident(@PathVariable ("id") Long id){
        accidentService.supprimerAccident( id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-accident")
    public ResponseEntity addAccident (@RequestBody Accident accident){
        accidentService.ajouterAccident(accident);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
