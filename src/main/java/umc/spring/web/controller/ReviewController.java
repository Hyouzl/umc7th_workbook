package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.member.MemberQueryService;
import umc.spring.service.review.ReviewCommandService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MissionResponseDto;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;
import umc.spring.web.dto.StoreResponseDto;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDto.addResultDto> addReview (@RequestBody @Valid ReviewRequestDto.addReviewDto request) {

        Review review = reviewCommandService.addReview(request);

        return ApiResponse.onSuccess(ReviewConverter.resultDto(review));
    }

    @GetMapping("/users/reivews")
    //@Operation은 이 API에 대한 설명을 넣게 되며 summary, description으로 설명을 적습니다.
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API",description = "내가 작성한 리뷰 목록 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    //@ApiResponses로 이 API의 응답을 담게 되며 내부적으로 @ApiResponse로 각각의 응답들을 담게 됩니다.
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MissionResponseDto.reviewReviewListDto> getReviewList (@CheckPage @RequestParam(name = "page") Integer page){

        Page<Review> getMyReviewList = memberQueryService.getMyReviewList(page-1);

        return ApiResponse.onSuccess(MissionConverter.reviewReviewListDto(getMyReviewList));
    }
}
