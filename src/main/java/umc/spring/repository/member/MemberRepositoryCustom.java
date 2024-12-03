package umc.spring.repository.member;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberDto;

import java.util.Optional;

public interface MemberRepositoryCustom {

    MemberDto findMemberInMyPage(Long memberId);

}
