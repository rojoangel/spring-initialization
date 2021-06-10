package com.example.initialization.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

public class TestBean {

  private static final Logger logger = Logger.getLogger(TestBean.class.toString());

  private static final String BAZ = initBaz();

  public TestBean() {
    logger.info("At TestBean constructor");
  }

  @PostConstruct
  public void postConstruct() {
    logger.info("At TestBean postConstruct");
  }

  @PreDestroy
  public void preDestroy() {
    logger.info("At TestBean preDestroy");
  }

  private static String initBaz() {
    logger.info("At TestBean initBaz");
    return "bar";
  }
}
