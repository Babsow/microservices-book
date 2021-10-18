package microservices.book.multipliaction.domain;
import lombok.Getter;
import lombok.ToString;



@Getter
@ToString
public class Multiplication {
  
  public Multiplication(int factorA, int factorB) {
    this.factorA = factorA;
    this.factorB = factorB;
  }
  private int factorA;
  private int factorB;
  private int result;

  
}
