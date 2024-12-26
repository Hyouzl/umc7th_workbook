package umc.spring.service.member;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDto;

import java.util.Optional;

public interface MemberCommandService {

    Member joinMember (MemberRequestDto.JoinDto request);


}
