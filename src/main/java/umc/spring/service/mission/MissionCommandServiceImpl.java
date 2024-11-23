package umc.spring.service.mission;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.repository.mission.MissionRepository;
import umc.spring.web.repository.store.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission addMissionToStore(MissionRequestDto.addMissionDto request) {


        Mission newMission = MissionConverter.toMission(request);

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() ->
                new TempHandler(ErrorStatus.STORE_NOT_FOUND));


        newMission.setStore(store);

        return missionRepository.save(newMission);
    }
}
