package umc.spring.repository.memberMission;

import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {


    List<MemberMissionDto> findMemberMissionByStatus (Long memberId, String status, int cursor);
    boolean existMissionByMemberId(Long missionId, Long memberId);

}
