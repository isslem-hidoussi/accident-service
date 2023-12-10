package com.isslem.accidentservice.service;

import com.isslem.accidentservice.model.Accident;
import com.isslem.accidentservice.repository.AccidentRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AccidentService {
    private final AccidentRepo accidentRepository;
    public void ajouterAccident(Accident accident){
        accidentRepository.save(accident);
    }
    public Optional<Accident> getAccident(Long id){
return accidentRepository.findById(id);

    }
    public List<Accident> getAllAccident(){
        List<Accident> accidents=accidentRepository.findAll();
        return accidents;

    }
    public void supprimerAccident(long id){
        accidentRepository.deleteById(id);
    }
}

