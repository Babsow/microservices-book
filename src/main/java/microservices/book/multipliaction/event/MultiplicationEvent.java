package microservices.book.multipliaction.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class  MultiplicationEvent implements Serializable {
      private final Long multiplicationResultAttempId;
      private final Long userId;
      private final boolean correct;

}
