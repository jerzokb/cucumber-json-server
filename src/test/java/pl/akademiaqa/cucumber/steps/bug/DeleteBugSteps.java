package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import pl.akademiaqa.api.bug.DeleteBugRequest;
import pl.akademiaqa.api.bug.ReadBugRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.handlers.bug.BugResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class DeleteBugSteps {

    private final Context context;
    private final DeleteBugRequest deleteBugRequest;
    private final ReadBugRequest readBugRequest;

    @When("I delete existing bug")
    public void i_delete_existing_bug() {
        int bugId = context.getBugResponse().getId();
        Response response = deleteBugRequest.deleteBug(bugId);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @When("I delete multiple bugs")
    public void i_delete_multiple_bugs() {
        List<BugResponse> allBugs = readBugRequest.readAllBugs();
        List<BugResponse> bugs = context.getBugResponseList();
        for (int i = allBugs.size(); i >= allBugs.size()-bugs.size(); i--) {
            int bugId = bugs.get(i).getId();
            Response response = deleteBugRequest.deleteBug(bugId);
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        }

//        List<BugResponse> bugs = context.getBugResponseList();
//        for (BugResponse bug : bugs) {
//            int bugId = bug.getId();
//            Response response = deleteBugRequest.deleteBug(bugId);
//            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
//        }
    }
}
