package umc.spring.service.member;

<<<<<<< HEAD

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
=======
import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
>>>>>>> 1ea42f8eb413ea5b5a259760b7ca8c6355979346
import umc.spring.web.dto.MemberDto;

public interface MemberQueryService {

    MemberDto findMemberInMyPage(Long memberId);
    Page<Review> getMyReviewList(Integer page);

    Page<Review> getMyReviewList(Integer page);

    Page<MemberMission> getMyMissionList(Integer page);

}
