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


    public static MemberResponseDto.memberMissionPreviewDto memberMissionPreviewDto (MemberMission memberMission) {

        return MemberResponseDto.memberMissionPreviewDto.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .missionStatus(memberMission.getMissionStatus())
                .build();

    }

    public static MemberResponseDto.memberMissionListPreviewDto memberMissionListInChallengingPreviewDto (Page<MemberMission> pageMemberMissionList) {

        List<MemberResponseDto.memberMissionPreviewDto> memberMissionPreviewDtoList
                = pageMemberMissionList.stream()
                .filter(memberMission -> MissionStatus.CHALLENGING.equals(memberMission.getMissionStatus()))
                .map(MemberMissionConverter::memberMissionPreviewDto)
                .collect(Collectors.toList());

        return MemberResponseDto.memberMissionListPreviewDto.builder()
                .memberMissionList(memberMissionPreviewDtoList)
                .listSize(pageMemberMissionList.getSize())
                .totalElements(pageMemberMissionList.getTotalElements())
                .isFirst(pageMemberMissionList.isFirst())
                .isLast(pageMemberMissionList.isLast())
                .totalPage(pageMemberMissionList.getTotalPages())
                .build();

    }




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
