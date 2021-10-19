package microservices.book.multipliaction.service;
import microservices.book.multipliaction.domain.Multiplication;
import microservices.book.multipliaction.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
    
  Multiplication createRandomMultiplication();

  boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

}
