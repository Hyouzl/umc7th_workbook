package umc.spring.web.repository.memberMission;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.QMission;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.web.dto.MemberMissionDto;
import umc.spring.web.dto.QMemberMissionDto;

import java.util.List;

@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;


    @Override
    public List<MemberMissionDto> findMemberMissionByStatus(Long memberId, String status, int cursor) {

        return jpaQueryFactory
                .select(new QMemberMissionDto(
                                memberMission.id,
                                mission.missionSpec,
                                mission.reward,
                                memberMission.missionStatus,
                                store.name,
                                store.score))
                        .from(memberMission)
                        .join(mission).on(memberMission.mission.id.eq(mission.id))
                        .join(store).on(mission.store.id.eq(store.id))
                        .where(
                                memberMission.member.id.eq(memberId)
                               .and(memberMission.missionStatus.eq(MissionStatus.valueOf(status)))
                               .and(memberMission.id.lt(cursor)))
                        .orderBy(memberMission.id.desc())
                        .limit(10)
                        .fetch();
    }
}

