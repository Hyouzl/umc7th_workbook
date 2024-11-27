package umc.spring.repository.mission;

import umc.spring.web.dto.MissionDto;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MissionDto> findMissionInHome (Long memberId, String regionName, int cursor);
}
