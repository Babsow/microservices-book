package microservices.book.multipliaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.book.multipliaction.service.MultiplicationService;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

  private final MultiplicationService multipliactionService;

  @Autowired
  MultiplicationResultAttemptController(final MultiplicationService multiplicationService){
    this.multipliactionService = multiplicationService;
  }

  @RequiredArgsConstructor
  @NoArgsConstructor(force = true)
  @Getter
  private static final class ResultResponse {
    private final boolean correct ;
  }
  
}
