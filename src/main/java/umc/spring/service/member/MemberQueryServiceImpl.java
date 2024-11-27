package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.web.dto.MemberDto;
import umc.spring.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public MemberDto findMemberInMyPage(Long memberId) {
        MemberDto memberDto = memberRepository.findMemberInMyPage(memberId);

        System.out.println(memberDto);

        return memberDto;
    }

    @Override
    public Page<Review> getMyReviewList(Integer page) {

        Member member = memberRepository.findById(1L).get();
        Page<Review> pageReviewList = reviewRepository.findByMember(member, PageRequest.of(page, 10));

        return pageReviewList;
    }


}
