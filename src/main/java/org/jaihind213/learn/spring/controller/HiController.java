package org.jaihind213.learn.spring.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vishnuhr on 24/7/17.
 */
@Controller
@Component
@EnableAutoConfiguration
@Slf4j
@RequestMapping(path = "/hi")
public class HiController {

  private final ResponseEntity response = new ResponseEntity<String>("नमस्ते, Hola, 喂, hi", HttpStatus.OK);

  @RequestMapping(method = {RequestMethod.GET})
  @ResponseBody
  public ResponseEntity<String> sayHi() {
    return response;
  }
}
