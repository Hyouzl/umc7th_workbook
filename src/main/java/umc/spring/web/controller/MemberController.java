package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.member.MemberCommandService;
import umc.spring.service.member.MemberQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.web.dto.MemberMissionDto;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.MissionResponseDto;


@RestController
@RequiredArgsConstructor
@Validated
public class MemberController {

    private final MemberCommandService memberCommandService;

    /**
     * 회원가입 API
     * **/
    @PostMapping("/users")
    @Operation(summary = "회원가입 API",description = "유저 회원가입 API")
    //@ApiResponses로 이 API의 응답을 담게 되며 내부적으로 @ApiResponse로 각각의 응답들을 담게 됩니다.
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberResponseDto.JoinResultDTO> join (@ExistCategories @RequestBody MemberRequestDto.JoinDto request) {
        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.joinResultDTO(member));
    }


}
