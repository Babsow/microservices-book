package microservices.book.multipliaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.book.multipliaction.domain.MultiplicationResultAttempt;
import microservices.book.multipliaction.service.MultiplicationService;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

  private final MultiplicationService multiplicationService;

  @Autowired
  MultiplicationResultAttemptController(final MultiplicationService multiplicationService){
    this.multiplicationService = multiplicationService;
  }

  @RequiredArgsConstructor
  @NoArgsConstructor(force = true)
  @Getter
  private static final class ResultResponse {
    private final boolean correct ;
  }
  
  @PostMapping
  ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt){
    boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
    MultiplicationResultAttempt attemptCpy = new MultiplicationResultAttempt(
                                             multiplicationResultAttempt.getUser(),
                                              multiplicationResultAttempt.getMultiplication(),
                                               multiplicationResultAttempt.getResultAttempt(), isCorrect);       

    return ResponseEntity.ok( attemptCpy);
  }

}
