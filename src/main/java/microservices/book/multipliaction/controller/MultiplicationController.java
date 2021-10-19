package microservices.book.multipliaction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.multipliaction.service.MultiplicationService;


@RestController
public class MultiplicationController {
    private final MultiplicationService multipliactionService ;

    @Autowired
    public MultiplicationController(final MultiplicationService multiplicationService){
       this.multipliactionService = multiplicationService;
  }

}
