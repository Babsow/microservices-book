package microservices.book.multipliaction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.multipliaction.domain.Multiplication;
import microservices.book.multipliaction.service.MultiplicationService;


@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {
    private final MultiplicationService multipliactionService ;

    @Autowired
    public MultiplicationController(final MultiplicationService multiplicationService){
       this.multipliactionService = multiplicationService;
  }

  @GetMapping("/random")
  Multiplication getRandomMultiplication(){
    return multipliactionService.createRandomMultiplication() ;
  }

}
