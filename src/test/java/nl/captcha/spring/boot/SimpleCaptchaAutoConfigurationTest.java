package nl.captcha.spring.boot;

import nl.captcha.servlet.ChineseCaptchaServlet;
import nl.captcha.servlet.SimpleCaptchaServlet;
import nl.captcha.servlet.StickyCaptchaServlet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCaptchaAutoConfigurationTest {

    private final ApplicationContextRunner runner = new ApplicationContextRunner()
            .withUserConfiguration(SimpleCaptchaAutoConfiguration.class);

    @Test
    void registersSimpleServletWithConfiguredPathAndDimensions() {
        runner.withPropertyValues("simple-captcha.captcha-type=simple",
                        "simple-captcha.simple-pattern=/captcha.jpg",
                        "simple-captcha.width=240", "simple-captcha.height=70")
                .run(context -> {
                    assertThat(context).hasNotFailed();
                    ServletRegistrationBean<?> registration = context.getBean("simpleCaptchaServlet", ServletRegistrationBean.class);
                    assertThat(registration.getServlet()).isInstanceOf(SimpleCaptchaServlet.class);
                    assertThat(registration.getUrlMappings()).containsExactly("/captcha.jpg");
                    assertThat(registration.getInitParameters()).containsEntry("width", "240").containsEntry("height", "70");
                    assertThat(context).doesNotHaveBean("chineseCaptchaServlet");
                    assertThat(context).doesNotHaveBean("stickyCaptchaServlet");
                });
    }

    @Test
    void registersChineseServletOnlyForChineseType() {
        runner.withPropertyValues("simple-captcha.captcha-type=chinese")
                .run(context -> {
                    assertThat(context).hasNotFailed();
                    ServletRegistrationBean<?> registration = context.getBean("chineseCaptchaServlet", ServletRegistrationBean.class);
                    assertThat(registration.getServlet()).isInstanceOf(ChineseCaptchaServlet.class);
                    assertThat(registration.getUrlMappings()).containsExactly("/chinese-captcha.jpg");
                    assertThat(context).doesNotHaveBean("simpleCaptchaServlet");
                });
    }

    @Test
    void registersStickyServletOnlyForStickyType() {
        runner.withPropertyValues("simple-captcha.captcha-type=sticky")
                .run(context -> {
                    assertThat(context).hasNotFailed();
                    ServletRegistrationBean<?> registration = context.getBean("stickyCaptchaServlet", ServletRegistrationBean.class);
                    assertThat(registration.getServlet()).isInstanceOf(StickyCaptchaServlet.class);
                    assertThat(registration.getUrlMappings()).containsExactly("/sticky-captcha.jpg");
                    assertThat(context).doesNotHaveBean("simpleCaptchaServlet");
                });
    }
}
