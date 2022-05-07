package pl.dofizjo.dofizjoapplication.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LoginAttemptService {

    private final int attemptLimit = 10;
    private LoadingCache<String, Integer> attemptsCache;

    public LoginAttemptService() {
        super();
        attemptsCache = CacheBuilder.newBuilder().expireAfterWrite(12, TimeUnit.HOURS)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String key) throws Exception {
                        return 0;
                    }
                });
    }

    public void loginSucceeded(String key) {
        log.info("Login attempt succeeded, origin: " + key);
        attemptsCache.invalidate(key);
    }

    public void loginFailed(String key) {
        log.warn("Login attempt failed; origin: " + key);

        int attempts = 0;
        try {
            attempts = attemptsCache.get(key);
        } catch (ExecutionException e) {
            attempts = 0;
        }

        attempts++;
        attemptsCache.put(key, attempts);
    }

    public boolean isBlocked(String key) {
        try {
            if (attemptsCache.get(key) >= attemptLimit) {
                log.warn("IP blocked: " + key);
                return true;
            } else {
                return false;
            }
        } catch (ExecutionException e) {
            return false;
        }
    }

}
