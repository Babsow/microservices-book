package microservices.book.multipliaction.repository;

import org.springframework.data.repository.CrudRepository;

import microservices.book.multipliaction.domain.Multiplication;

public interface MultiplicationRepository  extends
   CrudRepository<Multiplication, Long>{
  
}
