package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberMissionHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGING'")
    private MissionStatus missionStatus;


    public void setMember(Member member) {
        if(this.member != null) {
            member.getMemberMissionList().remove(this);
        }

        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public void setMission(Mission mission) {
        if(this.mission != null) {
            mission.getMemberMissionList().remove(this);
        }

        this.mission = mission;
        mission.getMemberMissionList().add(this);
    }

    public void completedMission () {
        if(MissionStatus.COMPLETE.equals(this.missionStatus)) {
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_CHALLENGING);
        }

        this.missionStatus = MissionStatus.COMPLETE;
    }

}
