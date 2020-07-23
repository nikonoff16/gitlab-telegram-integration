package ru.hostco.dvs.gs.gitlabtelegramintegration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationConfiguration {
    /**
     * Приватный токен от моего Гитлаба
     */
    private String gitLabPrivateToken;
}
