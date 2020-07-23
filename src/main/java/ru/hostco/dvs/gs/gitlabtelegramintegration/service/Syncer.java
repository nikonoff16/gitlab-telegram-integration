package ru.hostco.dvs.gs.gitlabtelegramintegration.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.hostco.dvs.gs.gitlabtelegramintegration.config.ApplicationConfiguration;
import ru.hostco.dvs.gs.gitlabtelegramintegration.dto.MergeRequestInfo;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class Syncer {

    private final ApplicationConfiguration applicationConfiguration;
    private final GitLabClient gitLabClient;

    @Scheduled(fixedDelay = 5 * 1000)
    public void updateMergeRequests() {
        final Collection<MergeRequestInfo> mergeRequests = gitLabClient.
                getMergeRequests(applicationConfiguration.getGitLabPrivateToken());


        log.info("mergeRequests");
    }

}
