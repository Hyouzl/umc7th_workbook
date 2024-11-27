package umc.spring.service.mission;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionDto;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {
    List<MissionDto> findMissionInHome(Long memberId, String regionName, int cursor);
    Optional<Mission> findMission(Long missionId);


}
