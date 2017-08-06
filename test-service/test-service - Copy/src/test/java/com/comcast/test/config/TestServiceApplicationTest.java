package com.comcast.test.config;

import com.comcast.xsp.boot.XspApplication;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class TestServiceApplicationTest {

  @Test
  public void shouldExtendXspApplication() throws Exception {
    TestServiceApplication app = new TestServiceApplication();
    assertThat(app, Matchers.instanceOf(XspApplication.class));
  }
}
