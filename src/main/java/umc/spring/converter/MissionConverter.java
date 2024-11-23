package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.MissionResponseDto;

import java.time.LocalDate;

public class MissionConverter {

    public static MissionResponseDto.AddMissionResultDto addMissionResultDto(Mission mission) {

        return MissionResponseDto.AddMissionResultDto.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .missionSpec(mission.getMissionSpec())
                .build();
    }


    public static Mission toMission (MissionRequestDto.addMissionDto addMissionDto) {
        return Mission.builder()
                .missionSpec(addMissionDto.getMissionSpec())
                .deadline(LocalDate.from(addMissionDto.getDeadline()))
                .reward(addMissionDto.getReward())
                .build();
    }
}
