package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
<<<<<<< HEAD
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.memberMission.MemberMissionRepository;
import umc.spring.repository.mission.MissionRepository;
=======
import umc.spring.domain.Review;
>>>>>>> 1ea42f8eb413ea5b5a259760b7ca8c6355979346
import umc.spring.repository.review.ReviewRepository;
import umc.spring.web.dto.MemberDto;
import umc.spring.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
<<<<<<< HEAD
    private final MemberMissionRepository memberMissionRepository;

=======
>>>>>>> 1ea42f8eb413ea5b5a259760b7ca8c6355979346
    @Override
    public MemberDto findMemberInMyPage(Long memberId) {
        MemberDto memberDto = memberRepository.findMemberInMyPage(memberId);

        System.out.println(memberDto);

        return memberDto;
    }

    @Override
    public Page<Review> getMyReviewList(Integer page) {

<<<<<<< HEAD
    @Override
    public Page<Review> getMyReviewList(Integer page) {

=======
>>>>>>> 1ea42f8eb413ea5b5a259760b7ca8c6355979346
        Member member = memberRepository.findById(1L).get();
        Page<Review> pageReviewList = reviewRepository.findByMember(member, PageRequest.of(page, 10));

        return pageReviewList;
    }
<<<<<<< HEAD

    @Override
    public Page<MemberMission> getMyMissionList(Integer page) {

        // 유저 하드 코딩
        Member member = memberRepository.findById(1L).get();
        Page<MemberMission> pageMemberMissionList = memberMissionRepository.findByMember(member, PageRequest.of(page, 10));


        return pageMemberMissionList;
    }
=======
>>>>>>> 1ea42f8eb413ea5b5a259760b7ca8c6355979346


}
