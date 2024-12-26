package umc.spring.web.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MissionDto {

    private Long id;
    private String storeName;
    private String missionSpec;
    private Integer reward;
    private float storeScore;
    private LocalDate deadline;


    @QueryProjection
    public MissionDto(Long id, String storeName, String missionSpec, Integer reward, float storeScore, LocalDate deadline) {
        this.id = id;
        this.storeName = storeName;
        this.missionSpec = missionSpec;
        this.reward = reward;
        this.storeScore = storeScore;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "MissionDto{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", missionSpec='" + missionSpec + '\'' +
                ", reward=" + reward +
                ", storeScore=" + storeScore +
                ", deadline=" + deadline +
                '}';
    }
}
