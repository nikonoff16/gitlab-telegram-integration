package ru.hostco.dvs.gs.gitlabtelegramintegration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = {"id"})
public class GitLabUser {
    Long id;
    String name;
    String username;
    String state;
    @JsonProperty("web_url")
    String webUrl;
    @JsonProperty("avatar_url")
    String avatarUrl;
    @JsonProperty("access_level")
    Long accessLevel;
    @JsonProperty("expires_at")
    LocalDateTime expiresAt;
}
