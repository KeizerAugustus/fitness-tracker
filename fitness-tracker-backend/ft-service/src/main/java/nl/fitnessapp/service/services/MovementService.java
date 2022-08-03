package nl.fitnessapp.service.services;

import nl.fitnessapp.enums.MuscleGroup;
import nl.fitnessapp.model.Movement;
import nl.fitnessapp.model.MovementDto;
import nl.fitnessapp.repositories.MovementRepository;
import nl.fitnessapp.service.mappers.MovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovementService {

    private final MovementRepository movementRepository;

    @Autowired
    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<MovementDto> getAllMovements() {
        return movementRepository.findAll().stream()
                .map(MovementMapper.INSTANCE::movementToMovementDto)
                .collect(Collectors.toList());
    }

    public List<String> getAllMusclegroups() {
        return Arrays.stream(MuscleGroup.values()).map(MuscleGroup::toString).collect(Collectors.toList());
    }

    public void addMovement(MovementDto movementDto) {
        Optional<MovementDto> movementOptional = getAllMovements().stream().filter(movementDto1
                        -> movementDto1.getName().replace(" ", "").equalsIgnoreCase(movementDto.getName().replace(" ", "")))
                .findFirst();

        if (movementOptional.isPresent()) {
            throw new IllegalStateException("Movement already exists..");
        } else movementRepository.save(MovementMapper.INSTANCE.movementDtoToMovement(movementDto));
    }

    public void deleteMovement(Integer movementId) {
        movementRepository.deleteById(movementId.longValue());
    }

    @Transactional
    public Movement changeMovement(MovementDto movementDto) {
        Movement movement = movementRepository.findById(movementDto.getId().longValue())
                .orElseThrow(() -> new IllegalStateException("Movement should be found.."));

        Movement movementUpdated = MovementMapper.INSTANCE.movementDtoToMovement(movementDto);
        movement.setName(movementUpdated.getName());
        movement.setMuscleGroup(movementUpdated.getMuscleGroup());

        return movement;
    }

}
