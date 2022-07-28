package nl.fitnessapp.service.services;

import nl.fitnessapp.model.MovementDto;
import nl.fitnessapp.repositories.MovementRepository;
import nl.fitnessapp.service.mappers.MovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementService {

    private final MovementRepository movementRepository;

    @Autowired
    public MovementService(MovementRepository movementRepository){
        this.movementRepository = movementRepository;
    }

    public List<MovementDto> getAllMovements(){
        return movementRepository.findAll().stream()
                .map(MovementMapper.INSTANCE::movementToMovementDto)
                .collect(Collectors.toList());
    }

}
