package umc.spring.service.review;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.repository.store.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review addReview(ReviewRequestDto.addReviewDto request) {

        Review newReview = ReviewConverter.toReview(request);

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() ->
                new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() ->
                new TempHandler(ErrorStatus.STORE_NOT_FOUND));

        newReview.setMember(member);
        newReview.setStore(store);

        return reviewRepository.save(newReview);
    }
}
