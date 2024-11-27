package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MemberDto;
import umc.spring.web.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    @Override
    public MemberDto findMemberInMyPage(Long memberId) {
        MemberDto memberDto = memberRepository.findMemberInMyPage(memberId);

        System.out.println(memberDto);

        return memberDto;
    }




}
