package umc.spring.web.service.mission;

import umc.spring.web.dto.MissionDto;

import java.util.List;

public interface MissionQueryService {
    List<MissionDto> findMissionInHome(Long memberId, String regionName, int cursor);
}
