package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDto.addResultDto resultDto(Review review) {
        return ReviewResponseDto.addResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDto.addReviewDto requestDto) {

        return Review.builder()
                .body(requestDto.getBody())
                .score(requestDto.getScore())
                .build();

    }


}
