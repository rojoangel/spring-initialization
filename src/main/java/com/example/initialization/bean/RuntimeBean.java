package com.example.initialization.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Component
public class RuntimeBean {

  private static final Logger logger = Logger.getLogger(RuntimeBean.class.toString());

  private static final String BAR = initBar();

  public RuntimeBean() {
    logger.info("At RuntimeBean constructor");
  }

  @PostConstruct
  public void postConstruct() {
    logger.info("At RuntimeBean postConstruct");
  }

  @PreDestroy
  public void preDestroy() {
    logger.info("At RuntimeBean preDestroy");
  }

  private static String initBar() {
    logger.info("At RuntimeBean initBar");
    return "bar";
  }
}
