package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.store.StoreCommandService;
import umc.spring.web.dto.StoreRequestDto;
import umc.spring.web.dto.StoreResponseDto;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/stores")
    public ApiResponse<StoreResponseDto.addResultDTO> addStore (@RequestBody @Valid StoreRequestDto.addStoreDto request) {

        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.addResultDTO(store));

    }




}
