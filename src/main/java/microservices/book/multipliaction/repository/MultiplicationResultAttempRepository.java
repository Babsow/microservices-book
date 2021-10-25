package microservices.book.multipliaction.repository;

import org.springframework.data.repository.CrudRepository;

import microservices.book.multipliaction.domain.MultiplicationResultAttempt;

public interface MultiplicationResultAttempRepository 
  extends CrudRepository<MultiplicationResultAttempt,Long>{

    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);
  
}
