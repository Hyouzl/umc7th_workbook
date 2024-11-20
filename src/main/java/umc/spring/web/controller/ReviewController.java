package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.review.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDto.addResultDto> addReview (@RequestBody @Valid ReviewRequestDto.addReviewDto request) {

        Review review = reviewCommandService.addReview(request);

        return ApiResponse.onSuccess(ReviewConverter.resultDto(review));
    }



}
