package microservices.book.multipliaction.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import microservices.book.multipliaction.domain.Multiplication;
import microservices.book.multipliaction.domain.MultiplicationResultAttempt;
import microservices.book.multipliaction.domain.User;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorServiceImplTest {

  private RandomGeneratorServiceImpl randomGeneratorServiceImpl;
  private MultiplicationServiceImpl multiplicationServiceImpl;

  @Before 
  public void setUp() {
    randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
  }

  @Test 
  public void generateRandomFactorIsBetweenExpectedLimits()
    throws Exception {
      List<Integer> randomFactors = IntStream.range(0,100).map(i-> randomGeneratorServiceImpl
      .generateRandomFactor()).boxed().collect(Collectors.toList());

      assertThat(randomFactors).isSubsetOf(IntStream.range(11, 100)
      .boxed().collect(Collectors.toList()));
    }

    @Test 
    public void chekCorrectAttemptTest(){

      Multiplication multiplication = new Multiplication(50, 60);

      User user = new User("John_doe");

      MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000);

      boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

      assertThat(attemptResult).isTrue();
    }


    @Test 
    public void checkWrongAttemptTest(){
      Multiplication multiplication = new Multiplication(50, 60);
      User user = new User("John_doe");
      MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3010);
      boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);
      assertThat(attemptResult).isFalse();
    }
  
}
