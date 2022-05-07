package pl.dofizjo.dofizjoapplication;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import pl.dofizjo.dofizjoapplication.service.LoginAttemptService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GuavaCacheTests {

    @Autowired
    LoginAttemptService loginAttemptService;

    @Test
    public void whenLoginAttemptLimitExceeded_thenIpBlocked() {
        // Given
        int attemptLimit = loginAttemptService.getAttemptLimit();
        MockHttpServletRequest request = new MockHttpServletRequest();
        String ip = getIp(request);

        // When
        for (int i = 0; i < attemptLimit; i++) {
            loginAttemptService.loginFailed(ip);
        }

        // Then
        assertThat(loginAttemptService.isBlocked(ip)).isEqualTo(true);
    }

    @Test
    public void whenLoginAttemptSuccess_thenAttemptLimitReset() {
        // Given
        int attemptLimit = loginAttemptService.getAttemptLimit();
        MockHttpServletRequest request = new MockHttpServletRequest();
        String ip = getIp(request);

        // When
        for (int i = 0; i < attemptLimit / 2; i++) {
            loginAttemptService.loginFailed(ip);
        }

        loginAttemptService.loginSucceeded(ip);

        // Then
        assertThat(loginAttemptService.getAttemptsCache().size()).isEqualTo(0);
    }

    public String getIp(MockHttpServletRequest request) {
        String header = request.getHeader("X-Forwarded-For");

        if (header == null) {
            return request.getRemoteAddr();
        } else {
            return header.split(",")[0];
        }
    }
}
