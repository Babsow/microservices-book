package microservices.book.multipliaction.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import microservices.book.multipliaction.domain.Multiplication;

public class MultiplicationServiceImplTest {
  
  private MultiplicationServiceImpl multiplicationServiceImpl;

  @Mock
  private RandomGeneratorService randomGeneratorService;

  @Before
  public void setUp(){
    MockitoAnnotations.openMocks(this);
   // multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
  }
  
  @Test
  public void createRandomMultiplicationTest(){

    given(randomGeneratorService.generateRandomFactor()).
    willReturn(50, 30);

    Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();


    assertThat(multiplication.getFactorA()).isEqualTo(50);
    assertThat(multiplication.getFactorB()).isEqualTo(30);
    //assertThat(multiplication.getResult()).isEqualTo(1500);


  }
}

