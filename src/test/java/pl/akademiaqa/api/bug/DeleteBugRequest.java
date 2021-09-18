package pl.akademiaqa.api.bug;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.url.JsonServerUrl;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class DeleteBugRequest {

    private final BaseRequest baseRequest;

    public Response deleteBug(int bugId) {

        return given()
                .spec(baseRequest.requestSetup())
                .when()
                .delete(JsonServerUrl.getBugPath(bugId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
