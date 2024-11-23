package umc.spring.service.memberMission;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;
import umc.spring.web.repository.member.MemberRepository;
import umc.spring.web.repository.memberMission.MemberMissionRepository;
import umc.spring.web.repository.mission.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {


    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public List<MemberMissionDto> findMemberMissionByMemberIdAndStatus(Long memberId, String status, int cursor) {

        List<MemberMissionDto> filteredMemberMission = memberMissionRepository.findMemberMissionByStatus(memberId, status,cursor);

        filteredMemberMission.forEach(memberMissionDto -> System.out.println(
                "memberMissionDto : " + memberMissionDto
        ));

        return filteredMemberMission;
    }

    @Override
    public MemberMission addMemberMission(MemberMissionDto.addMemberMissionDto addMemberMissionDto) {

        Mission mission = missionRepository.findById(addMemberMissionDto.getMissionId()).orElseThrow(() ->
                new TempHandler(ErrorStatus.MISSION_NOT_FOUND));

        Member member = memberRepository.findById(addMemberMissionDto.getMemberId()).orElseThrow(() ->
                new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));


        MemberMission memberMission = MemberMissionConverter.toMemberMission(addMemberMissionDto);

        memberMission.setMember(member);
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
    }


}
