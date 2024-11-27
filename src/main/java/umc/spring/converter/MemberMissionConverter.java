package umc.spring.converter;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;

public class MemberMissionConverter {


    public static MemberMissionDto.resultAddMemberMission resultAddMemberMission(MemberMission memberMission) {


        return MemberMissionDto.resultAddMemberMission.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();

    }

    public static MemberMission toMemberMission (MemberMissionDto.addMemberMissionDto addMemberMissionDto) {
        return MemberMission.builder()
                .missionStatus(MissionStatus.CHALLENGING)
                .build();
    }


}
