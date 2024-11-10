package umc.spring.web.repository.mission;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.QMission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.web.dto.MissionDto;
import umc.spring.web.dto.QMissionDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QRegion region = QRegion.region;
    private final QStore store = QStore.store;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission =QMemberMission.memberMission;


    @Override
    public List<MissionDto> findMissionInHome(Long memberId, String regionName, int cursor) {
        // regionName에 해당하는 regionId를 서브쿼리로 선택
        Long regionId = jpaQueryFactory
        .select(region.id)
        .from(region)
        .where(region.name.eq(regionName))
        .fetchOne(); // 해당 regionName의 regionId를 가져옵니다.


        List<Long> memberMissionIds = jpaQueryFactory
                .select(memberMission.mission.id)
                .from(memberMission)
                .where(memberMission.member.id.eq(memberId))
                .fetch(); // myMission에서 missionId를 가져오는 쿼리

        List<MissionDto> missions = jpaQueryFactory
                .select(new QMissionDto(mission.id,
                        store.name,
                        mission.missionSpec,
                        mission.reward,
                        store.score,
                        mission.deadline))
                .from(mission)
                .join(store).on(store.region.id.eq(regionId))
                .where(
                        mission.id.notIn(memberMissionIds)
                                .and(mission.id.lt(cursor))  // Apply cursor condition
                )
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();


        if (missions.isEmpty()) {
            missions = jpaQueryFactory
                    .select(new QMissionDto(mission.id,
                            store.name,
                            mission.missionSpec,
                            mission.reward,
                            store.score,
                            mission.deadline))
                    .from(mission)
                    .join(store).on(store.region.id.eq(regionId))
                    .where(mission.id.notIn(memberMissionIds))
                    .orderBy(mission.id.desc())
                    .limit(10)
                    .fetch();
        }

        return missions;


    }
}

