package umc.spring.service.memberMission;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;

import java.util.List;
import java.util.Optional;

public interface MemberMissionService {

    // 진행중, 진행 완료 미션 조회
    List<MemberMissionDto> findMemberMissionByMemberIdAndStatus(Long memberId, String status, int cursor);

    MemberMission addMemberMission(MemberMissionDto.addMemberMissionDto addMemberMissionDto);
    boolean existMemberMission (Long missionId, Long memberId);
    Optional<MemberMission> findMemberMission (Long MemberMissionId);



}
