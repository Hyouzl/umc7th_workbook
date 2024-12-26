package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.MissionResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMissionDto.resultAddMemberMission resultAddMemberMission(MemberMission memberMission) {

        return MemberMissionDto.resultAddMemberMission.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();

    }

    public static MemberMission toMemberMission () {
        return MemberMission.builder()
                .missionStatus(MissionStatus.CHALLENGING)
                .build();
    }


}
