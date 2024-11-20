package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.service.member.MemberCommandService;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/users")
    public ApiResponse<MemberResponseDto.JoinResultDTO> join (@RequestBody @Valid MemberRequestDto.JoinDto request) {
        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.joinResultDTO(member));
    }


}
