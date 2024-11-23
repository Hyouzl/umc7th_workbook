package umc.spring.service.mission;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDto;

public interface MissionCommandService {

    Mission addMissionToStore(MissionRequestDto.addMissionDto request);

}
