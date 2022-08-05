package nl.fitnessapp.service.mappers;

import nl.fitnessapp.model.*;

import java.util.ArrayList;
import java.util.List;

public class TemplateToWorkoutMapper {

    public static NewWorkoutDto map(WorkoutTemplateDto template) {
        NewWorkoutDto newWorkoutDto = new NewWorkoutDto();
        newWorkoutDto.setName(template.getTemplateName());

        SetRepMap setRepMap = new SetRepMap();

        template.getSetTemplates().forEach(setTemplate -> {
            List<RepInfoDto> repInfoDtoList = new ArrayList<>();
            for (int i = 0; i < setTemplate.getAmountOfTimes(); i++) {
                repInfoDtoList.add(new RepInfoDto());
            }

            SetInfoDto setInfoDto = new SetInfoDto().movement(setTemplate.getMovement())
                    .orderOfSet(setTemplate.getOrderOfSet())
                    .amountOfTimes(setTemplate.getAmountOfTimes())
                    .movementType(setTemplate.getMovementType());

            newWorkoutDto.addSetInfoListItem(setInfoDto);
            setRepMap.put(setInfoDto.getMovement().getName(), repInfoDtoList);
        });

        newWorkoutDto.setMovements(setRepMap);
        return newWorkoutDto;
    }
}
