package umc.spring.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.review.ReviewCommandService;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;




}
