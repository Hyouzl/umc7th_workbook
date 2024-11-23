package umc.spring.service.memberMission;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionService {

    // 진행중, 진행 완료 미션 조회
    List<MemberMissionDto> findMemberMissionByMemberIdAndStatus(Long memberId, String status, int cursor);

    MemberMission addMemberMission(MemberMissionDto.addMemberMissionDto addMemberMissionDto);

}
