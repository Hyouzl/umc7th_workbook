package umc.spring.service.memberMission;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.web.dto.MemberMissionDto;
import umc.spring.web.repository.memberMission.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionServiceImpl implements MemberMissionService {


    private final MemberMissionRepository memberMissionRepository;
    @Override
    public List<MemberMissionDto> findMemberMissionByMemberIdAndStatus(Long memberId, String status, int cursor) {

        List<MemberMissionDto> filteredMemberMission = memberMissionRepository.findMemberMissionByStatus(memberId, status,cursor);

        filteredMemberMission.forEach(memberMissionDto -> System.out.println(
                "memberMissionDto : " + memberMissionDto
        ));

        return filteredMemberMission;
    }


}
