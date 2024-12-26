package umc.spring.converter;

import lombok.Getter;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.MissionResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {


    public static MemberResponseDto.JoinResultDTO joinResultDTO (Member member) {
        return MemberResponseDto.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember (MemberRequestDto.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1: gender = Gender.MALE; break;
            case 2: gender = Gender.FEMALE; break;
            case 3: gender = Gender.NONE; break;
        }

        return Member.builder()
                .address(request.getAddress())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .role(request.getRole())   // 추가된 코드
                .memberPreferList(new ArrayList<>())
                .build();
    }



    public static MemberResponseDto.ReviewPreviewDto reviewReviewDto (Review review) {

        return MemberResponseDto.ReviewPreviewDto.builder()
                .storeName(review.getStore().getName())
                .ownerNickname(review.getMember().getName())
                .body(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();

    }

    public static MemberResponseDto.ReviewPreviewListDto reviewPreviewListDto (Page<Review> pageReviewList) {
        List<MemberResponseDto.ReviewPreviewDto> reviewReviewDtoList
                = pageReviewList.stream().map(MemberConverter::reviewReviewDto).collect(Collectors.toList());

        return MemberResponseDto.ReviewPreviewListDto.builder()
                .reviewReviewDtoList(reviewReviewDtoList)
                .listSize(pageReviewList.getSize())
                .totalPage(pageReviewList.getTotalPages())
                .totalElements(pageReviewList.getTotalElements())
                .isFirst(pageReviewList.isFirst())
                .isLast(pageReviewList.isLast())
                .build();

    }


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
                .map(MemberConverter::memberMissionPreviewDto)
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


}
