package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.mission.MissionCommandService;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.MissionResponseDto;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/missions")
    public ApiResponse<MissionResponseDto.AddMissionResultDto> addMission (@RequestBody @Valid MissionRequestDto.addMissionDto request) {

        Mission mission = missionCommandService.addMissionToStore(request);

        return ApiResponse.onSuccess(MissionConverter.addMissionResultDto(mission));
    }






}
