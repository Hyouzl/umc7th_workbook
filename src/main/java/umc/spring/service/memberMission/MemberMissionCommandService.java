package umc.spring.service.memberMission;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;

public interface MemberMissionCommandService {

    MemberMission addMemberMission(MemberMissionDto.addMemberMissionDto addMemberMissionDto);
}
