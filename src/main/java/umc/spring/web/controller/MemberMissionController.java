package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberMission.MemberMissionService;
import umc.spring.web.dto.MemberMissionDto;

@RestController
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/memberMissions")
    public ApiResponse<MemberMissionDto.resultAddMemberMission> addMemberMission (@RequestBody @Valid MemberMissionDto.addMemberMissionDto request) {
        MemberMission memberMission = memberMissionService.addMemberMission(request);

        return ApiResponse.onSuccess(MemberMissionConverter.resultAddMemberMission(memberMission));
    }


}
