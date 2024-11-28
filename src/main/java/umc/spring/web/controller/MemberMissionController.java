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
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.member.MemberQueryService;
import umc.spring.service.memberMission.MemberMissionService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberMissionDto;
import umc.spring.web.dto.MemberResponseDto;

@RestController
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/users/missions")
    @Operation(summary = "멤버 미션 추가 API",description = "멤버가 도전하는 미션을 추가하는 API이다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberMissionDto.resultAddMemberMission> addMemberMission (@RequestBody @Valid MemberMissionDto.addMemberMissionDto request) {
        MemberMission memberMission = memberMissionService.addMemberMission(request);

        return ApiResponse.onSuccess(MemberMissionConverter.resultAddMemberMission(memberMission));
    }

    @GetMapping("/users/missions")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API",description = "내가 진행중인 미션 목록 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberResponseDto.memberMissionListPreviewDto> getMissionList (@CheckPage @RequestParam(name = "page") Integer page) {

        Page<MemberMission> getMyMissionList = memberQueryService.getMyMissionList(page-1);

        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionListInChallengingPreviewDto(getMyMissionList));
    }

    @PatchMapping("/users/missions")
    @Operation(summary = "진행중인 미션 진행 완료로 바꾸기 API",description = "진행중인 미션 진행 완료로 바꾸는 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberResponseDto.memberMissionPreviewDto> updateMissionStatus (@RequestBody @Valid MemberMissionDto.updateMemberMissionStatusDto request) {

        System.out.println(request.getMemberMissionId());
        MemberMission memberMission = memberQueryService.updateMemberMissionStatus(request.getMemberMissionId());

        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionPreviewDto(memberMission));
    }

}
