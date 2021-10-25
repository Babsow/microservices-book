package microservices.book.multipliaction.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import microservices.book.multipliaction.domain.Multiplication;
import microservices.book.multipliaction.domain.MultiplicationResultAttempt;
import microservices.book.multipliaction.domain.User;
import microservices.book.multipliaction.repository.MultiplicationResultAttempRepository;
import microservices.book.multipliaction.repository.UserRepository;


@Service
public class MultiplicationServiceImpl implements MultiplicationService{
  
  private RandomGeneratorService randomGeneratorService;
  private MultiplicationResultAttempRepository 
          attempRepository;
  private UserRepository userRepository;
  @Autowired
  public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService,
                                    final MultiplicationResultAttempRepository
                                            attemptRepository,
                                            final UserRepository userRepository){
    this.randomGeneratorService = randomGeneratorService;
    this.attempRepository = attemptRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Multiplication createRandomMultiplication(){
    int factorA = randomGeneratorService.generateRandomFactor();
    int factorB = randomGeneratorService.generateRandomFactor();
    
    return new Multiplication(factorA, factorB);
  }

  @Transactional
  @Override
  public  boolean checkAttempt(final MultiplicationResultAttempt resultAttempt){

    Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());
    boolean correct = resultAttempt.getResultAttempt() == resultAttempt.getMultiplication().
                                                          getFactorA()*resultAttempt.getMultiplication().
                                                          getFactorB();
    Assert.isTrue(!resultAttempt.isCorrect(), "You can't send an attempt marked as correct");
    MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(
                                                user.orElse(resultAttempt.getUser()),
                                                resultAttempt.getMultiplication(), 
                                                resultAttempt.getResultAttempt(), correct);
                                                

    attempRepository.save(checkedAttempt);
    return correct ;
  }

  
  public List<MultiplicationResultAttempt> getStatsForUser(String userAlias){
    return attempRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
  }
}
