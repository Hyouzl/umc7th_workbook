package umc.spring.service.memberMission;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<MemberMissionDto> findMemberMissionByMemberIdAndStatus(Long memberId, String status, int cursor) {

        List<MemberMissionDto> filteredMemberMission = memberMissionRepository.findMemberMissionByStatus(memberId, status,cursor);

        filteredMemberMission.forEach(memberMissionDto -> System.out.println(
                "memberMissionDto : " + memberMissionDto
        ));

        return filteredMemberMission;
    }

    @Override
    public boolean existMemberMission(Long missionId, Long memberId) {
        return memberMissionRepository.existMissionByMemberId(missionId, memberId);
    }

    @Override
    public Optional<MemberMission> findMemberMission(Long memberMissionId) {
        return memberMissionRepository.findById(memberMissionId);
    }

    @Override
    public Page<MemberMission> getMyMissionList(Integer page) {

        // 유저 하드 코딩
        Member member = memberRepository.findById(1L).get();
        Page<MemberMission> pageMemberMissionList = memberMissionRepository.findByMember(member, PageRequest.of(page, 10));


        return pageMemberMissionList;
    }

    @Override
    public MemberMission updateMemberMissionStatus(Long memberMissionId) {

        MemberMission memberMission = memberMissionRepository.findById(memberMissionId).get();
        memberMission.completedMission();

        return memberMissionRepository.save(memberMission);
    }


}
