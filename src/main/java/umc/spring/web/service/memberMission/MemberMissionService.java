package umc.spring.web.service.memberMission;

import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionService {
    public List<MemberMissionDto> findMemberMissionByMemberIdAndStatus(Long memberId, String status, int cursor);
}
