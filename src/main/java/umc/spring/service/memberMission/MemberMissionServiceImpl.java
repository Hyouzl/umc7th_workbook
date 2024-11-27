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
import umc.spring.web.dto.MemberMissionDto;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.memberMission.MemberMissionRepository;
import umc.spring.repository.mission.MissionRepository;

import java.util.List;
import java.util.Optional;

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
                new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 유저 하드 코딩
        Member member = memberRepository.findById(1L).orElseThrow(() ->
                new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));


        MemberMission memberMission = MemberMissionConverter.toMemberMission(addMemberMissionDto);

        memberMission.setMember(member);
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
    }

    @Override
    public boolean existMemberMission(Long missionId, Long memberId) {
        return memberMissionRepository.existMissionByMemberId(missionId, memberId);
    }

    @Override
    public Optional<MemberMission> findMemberMission(Long memberMissionId) {
        return memberMissionRepository.findById(memberMissionId);
    }

}
