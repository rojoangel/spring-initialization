package com.example.initialization;

import com.example.initialization.bean.TestBean;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class InitializationApplicationTests {

  @Autowired private TestBean testBean;

  private static final Logger logger =
      Logger.getLogger(InitializationApplicationTests.class.toString());

  private static final String FOO = initFoo();

  public InitializationApplicationTests() {
    logger.info("At InitializationApplicationTests constructor");
  }

  @PostConstruct
  public void postConstruct() {
    logger.info("At InitializationApplicationTests postConstruct");
  }

  @BeforeAll
  public static void beforeAll() {
    logger.info("At InitializationApplicationTests beforeAll");
  }

  @BeforeEach
  public void beforeEach() {
    logger.info("At InitializationApplicationTests beforeEach");
  }

  @Test
  @DirtiesContext
  void oneTest() {
    assertThat(testBean, notNullValue(TestBean.class));
  }

  @Test
  @DirtiesContext
  void anotherTest() {
    assertThat(testBean, notNullValue(TestBean.class));
  }

  @AfterEach
  public void afterEach() {
    logger.info("At InitializationApplicationTests afterEach");
  }

  @AfterAll
  public static void afterAll() {
    logger.info("At InitializationApplicationTests afterAll");
  }

  @PreDestroy
  public void preDestroy() {
    logger.info("At InitializationApplicationTests preDestroy");
  }

  private static String initFoo() {
    logger.info("At InitializationApplicationTests initFoo");
    return "foo";
  }

  @TestConfiguration
  public static class TestConfig {

    @Bean
    public TestBean testBean() {
      return new TestBean();
    }
  }
}
