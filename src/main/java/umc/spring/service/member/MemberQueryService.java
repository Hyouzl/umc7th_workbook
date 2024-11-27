package umc.spring.service.member;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MemberDto;

public interface MemberQueryService {

    MemberDto findMemberInMyPage(Long memberId);

}
