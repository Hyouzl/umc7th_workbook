package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.domain.FoodCategory;
import umc.spring.web.repository.member.FoodCategoryRepository;


@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService{

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public FoodCategory findById(Long id) {
        return foodCategoryRepository.findById(id).orElseThrow(() ->
                new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
    }
}
