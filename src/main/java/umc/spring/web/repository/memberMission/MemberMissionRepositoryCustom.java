package umc.spring.web.repository.memberMission;

import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {


    public List<MemberMissionDto> findMemberMissionByStatus (Long memberId, String status, int cursor);



}
