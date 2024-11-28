package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.review.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getMyReviewList(Integer page) {

        // 유저 하드 코딩
        Member member = memberRepository.findById(1L).get();
        Page<Review> pageReviewList = reviewRepository.findByMember(member, PageRequest.of(page, 10));

        return pageReviewList;
    }

}
