package ru.hostco.dvs.gs.gitlabtelegramintegration.service;

import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.hostco.dvs.gs.gitlabtelegramintegration.dto.GitLabUser;
import ru.hostco.dvs.gs.gitlabtelegramintegration.dto.MergeRequestInfo;

import java.util.Collection;

@FeignClient(value = "gitlab-api", url = "https://gitlab.com")
public interface GitLabClient {

    @RequestMapping(value = "/api/v4/merge_requests", method = RequestMethod.GET)  //Чтобы клиент знал, куда ему ходить
    Collection<MergeRequestInfo> getMergeRequests(
            @NonNull @RequestHeader("Private-Token") String privateToken);

    @RequestMapping(value = "/api/v4/user", method = RequestMethod.GET)
    GitLabUser getCurrentUserInfo(
            @NonNull @RequestHeader("Private-Token") String privateToken);

    @RequestMapping(value = "/api/v4/{projectId}/merge_requests/{mergeRequestId", method = RequestMethod.PUT)
    MergeRequestInfo changeMergeRequestAssignee(
            @NonNull @RequestHeader("Private-Token") String privateToken,
            @NonNull @PathVariable Long projectId,
            @NonNull @PathVariable Long mergeRequestId,
            @NonNull @RequestParam("assignee_id") Long assigneeId);

    @RequestMapping(value = "/api/v4/projects/{projectId}/members", method = RequestMethod.GET)
    Collection<GitLabUser> getProjectMembers(
            @NonNull @RequestHeader("Private-Token") String privateToken,
            @NonNull @RequestHeader Long projectId
    );
}
