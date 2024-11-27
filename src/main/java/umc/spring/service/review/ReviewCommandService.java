package umc.spring.service.review;


import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDto;

public interface ReviewCommandService {

    Review addReview(ReviewRequestDto.addReviewDto request);
}
