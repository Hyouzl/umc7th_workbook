package umc.spring.service.member;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDto;

public interface MemberCommandService {

    Member joinMember (MemberRequestDto.JoinDto request);


}
