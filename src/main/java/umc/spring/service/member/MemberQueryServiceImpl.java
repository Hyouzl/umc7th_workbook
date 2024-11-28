package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.memberMission.MemberMissionRepository;

import umc.spring.repository.review.ReviewRepository;
import umc.spring.web.dto.MemberDto;
import umc.spring.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public MemberDto findMemberInMyPage(Long memberId) {

        MemberDto memberDto = memberRepository.findMemberInMyPage(memberId);

        return memberDto;
    }

    @Override
    public Page<Review> getMyReviewList(Integer page) {

        // 유저 하드 코딩
        Member member = memberRepository.findById(1L).get();
        Page<Review> pageReviewList = reviewRepository.findByMember(member, PageRequest.of(page, 10));

        return pageReviewList;
    }

}
