package umc.spring.web.service.member;

import umc.spring.web.dto.MemberDto;

public interface MemberQueryService {

    MemberDto findMemberInMyPage(Long memberId);
}
