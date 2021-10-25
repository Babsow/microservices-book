package microservices.book.multipliaction.service;
import java.util.List;

import microservices.book.multipliaction.domain.Multiplication;
import microservices.book.multipliaction.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
    
  Multiplication createRandomMultiplication();

  public List<MultiplicationResultAttempt> getStatsForUser(String userAlias);
  boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

}
