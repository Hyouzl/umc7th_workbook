package umc.spring.repository.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;
import umc.spring.web.dto.MemberDto;
import umc.spring.web.dto.QMemberDto;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public MemberDto findMemberInMyPage(Long memberId) {

        return jpaQueryFactory
                .select(new QMemberDto(
                        member.name,
                        member.email,
                        member.address,
                        member.point))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();

    }


}
