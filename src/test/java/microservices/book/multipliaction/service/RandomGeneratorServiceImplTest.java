package microservices.book.multipliaction.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorServiceImplTest {

  private RandomGeneratorServiceImpl randomGeneratorServiceImpl;

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
}