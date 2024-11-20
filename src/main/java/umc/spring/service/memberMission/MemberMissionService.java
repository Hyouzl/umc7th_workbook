package umc.spring.service.memberMission;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionService {
    List<MemberMissionDto> findMemberMissionByMemberIdAndStatus(Long memberId, String status, int cursor);

    MemberMission addMemberMission()

}
