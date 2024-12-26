package umc.spring.service.memberMission;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;

import java.util.List;
import java.util.Optional;

public interface MemberMissionQueryService {

    // 진행중, 진행 완료 미션 조회
    List<MemberMissionDto> findMemberMissionByMemberIdAndStatus(Long memberId, String status, int cursor);
    boolean existMemberMission (Long missionId, Long memberId);
    Optional<MemberMission> findMemberMission (Long MemberMissionId);
    Page<MemberMission> getMyMissionList(Integer page);
    MemberMission updateMemberMissionStatus(Long memberMissionId);



}
