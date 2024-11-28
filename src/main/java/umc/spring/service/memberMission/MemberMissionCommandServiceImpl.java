package umc.spring.service.memberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.memberMission.MemberMissionRepository;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.web.dto.MemberMissionDto;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission addMemberMission(MemberMissionDto.addMemberMissionDto addMemberMissionDto) {

        Mission mission = missionRepository.findById(addMemberMissionDto.getMissionId()).orElseThrow(() ->
                new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 유저 하드 코딩
        Member member = memberRepository.findById(1L).orElseThrow(() ->
                new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission();

        memberMission.setMember(member);
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
    }

}
