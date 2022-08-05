package nl.fitnessapp.service.mappers;

import nl.fitnessapp.model.*;

import java.util.ArrayList;
import java.util.List;

public class TemplateToWorkoutMapper {

    public static NewWorkoutDto map(WorkoutTemplateDto template) {
        NewWorkoutDto newWorkoutDto = new NewWorkoutDto();
        newWorkoutDto.setName(template.getTemplateName());

        template.getSetTemplates().forEach(setTemplate -> {
            List<RepInfoDto> repInfoDtoList = new ArrayList<>();
            for (int i = 0; i < setTemplate.getAmountOfTimes(); i++) {
                repInfoDtoList.add(new RepInfoDto());
            }

            SetInfoDto setInfoDto = new SetInfoDto().movement(setTemplate.getMovement())
                    .orderOfSet(setTemplate.getOrderOfSet())
                    .amountOfTimes(setTemplate.getAmountOfTimes())
                    .movementType(setTemplate.getMovementType());

            setInfoDto.setReps(repInfoDtoList);
            newWorkoutDto.addSetInfoListItem(setInfoDto);
        });

        return newWorkoutDto;
    }
}
