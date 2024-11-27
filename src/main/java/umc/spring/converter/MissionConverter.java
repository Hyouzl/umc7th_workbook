package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.MissionResponseDto;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDto.reviewReviewDto reviewReviewDto (Review review) {

        return MissionResponseDto.reviewReviewDto.builder()
                .storeName(review.getStore().getName())
                .ownerNickname(review.getMember().getName())
                .body(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();

    }

    public static MissionResponseDto.reviewReviewListDto reviewReviewListDto(Page<Review> pageReviewList) {
        List<MissionResponseDto.reviewReviewDto> reviewReviewDtoList
                = pageReviewList.stream().map(MissionConverter::reviewReviewDto).collect(Collectors.toList());

        return MissionResponseDto.reviewReviewListDto.builder()
                .reviewReviewDtoList(reviewReviewDtoList)
                .listSize(pageReviewList.getSize())
                .totalPage(pageReviewList.getTotalPages())
                .totalElements(pageReviewList.getTotalElements())
                .isFirst(pageReviewList.isFirst())
                .isLast(pageReviewList.isLast())
                .build();

    }

    public static MissionResponseDto.AddMissionResultDto addMissionResultDto(Mission mission) {

        return MissionResponseDto.AddMissionResultDto.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .missionSpec(mission.getMissionSpec())
                .build();
    }


    public static Mission toMission (MissionRequestDto.addMissionDto addMissionDto) {
        return Mission.builder()
                .missionSpec(addMissionDto.getMissionSpec())
                .deadline(LocalDate.from(addMissionDto.getDeadline()))
                .reward(addMissionDto.getReward())
                .build();
    }


}
