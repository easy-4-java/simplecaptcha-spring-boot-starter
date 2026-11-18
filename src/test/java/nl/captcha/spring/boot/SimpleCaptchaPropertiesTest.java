package nl.captcha.spring.boot;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleCaptchaPropertiesTest {

    @Test
    void exposesDefaultsAndSetters() {
        SimpleCaptchaProperties properties = new SimpleCaptchaProperties();
        assertThat(properties.getCaptchaType()).isEqualTo(SimpleCaptchaProperties.CaptchaType.SIMPLE);
        assertThat(properties.getSimplePattern()).isEqualTo("/simple-captcha.jpg");
        assertThat(properties.getChinesePattern()).isEqualTo("/chinese-captcha.jpg");
        assertThat(properties.getStickyPattern()).isEqualTo("/sticky-captcha.jpg");
        assertThat(properties.getWidth()).isEqualTo(200);
        assertThat(properties.getHeight()).isEqualTo(50);

        properties.setCaptchaType(SimpleCaptchaProperties.CaptchaType.CHINESE);
        properties.setSimplePattern("/simple.jpg");
        properties.setChinesePattern("/chinese.jpg");
        properties.setStickyPattern("/sticky.jpg");
        properties.setWidth(240);
        properties.setHeight(70);
        assertThat(properties.getCaptchaType()).isEqualTo(SimpleCaptchaProperties.CaptchaType.CHINESE);
        assertThat(properties.getSimplePattern()).isEqualTo("/simple.jpg");
        assertThat(properties.getChinesePattern()).isEqualTo("/chinese.jpg");
        assertThat(properties.getStickyPattern()).isEqualTo("/sticky.jpg");
        assertThat(properties.getWidth()).isEqualTo(240);
        assertThat(properties.getHeight()).isEqualTo(70);
    }

    @Test
    void resolvesAllCaptchaTypesIgnoringCase() {
        for (SimpleCaptchaProperties.CaptchaType type : SimpleCaptchaProperties.CaptchaType.values()) {
            assertThat(SimpleCaptchaProperties.CaptchaType.valueOfIgnoreCase(type.get().toUpperCase())).isEqualTo(type);
            assertThat(type.equals(type)).isTrue();
            assertThat(type.equals(type.get())).isTrue();
        }
        assertThatThrownBy(() -> SimpleCaptchaProperties.CaptchaType.valueOfIgnoreCase("unknown"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
