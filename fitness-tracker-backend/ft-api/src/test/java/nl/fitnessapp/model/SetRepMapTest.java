package nl.fitnessapp.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

class SetRepMapTest {

    @Test
    void testMapProperties() {
        //Given
        SetInfoDto setInfoDto = new SetInfoDto().orderOfSet(1).amountOfTimes(1).movement(new MovementDto().name("Bench Press"));
        RepInfoDto repInfoDto = new RepInfoDto().reps(8).weight(new BigDecimal(10));
        RepInfoDto repInfoDto2 = new RepInfoDto().reps(6).weight(new BigDecimal(12));
        //When
        SetRepMap setRepMap = new SetRepMap();
        setRepMap.addSetInfoItem(setInfoDto);
        setRepMap.put(setInfoDto.getMovement().getName(), new ArrayList<RepInfoDto>());
        setRepMap.get(setInfoDto.getMovement().getName()).add(repInfoDto);
        setRepMap.get(setInfoDto.getMovement().getName()).add(repInfoDto2);
        //Then
        assertThat(setRepMap.keySet().size()).as("checking size").isEqualTo(1);
        assertThat(setRepMap.get("Bench Press").size()).as("checking size").isEqualTo(2);
        assertThat(setRepMap.get("Bench Press")).as("checking content").containsOnly(repInfoDto, repInfoDto2);
    }
}
