package umc.spring.repository.member;

import umc.spring.web.dto.MemberDto;

public interface MemberRepositoryCustom {

    MemberDto findMemberInMyPage(Long memberId);
}