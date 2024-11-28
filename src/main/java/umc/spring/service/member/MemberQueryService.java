package umc.spring.service.member;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

import umc.spring.web.dto.MemberDto;

public interface MemberQueryService {

    MemberDto findMemberInMyPage(Long memberId);
    Page<Review> getMyReviewList(Integer page);

}
