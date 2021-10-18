package microservices.book.multipliaction.domain;
import lombok.AllArgsConstructor ;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
public class Multiplication {
  
  private int factorA;
  private int factorB;
  private int result;

  
}
