package com.klix.backend.config;

import com.klix.backend.utils.SpringApplicationContext;
import com.klix.backend.global.wrappers.restassured.RequestBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class  Base {

    public static RequestBuilder requestBuilderForTT2WithAuthHeader(String token, String path) {
        return new RequestBuilder()
                .specification(requestSpecificationForTT2WithAuthHeader(token, path));
    }

    public static RequestBuilder requestBuilderForTT2WithAuthHeader(Integer id, String token, String path) {
        return new RequestBuilder()
                .specification(requestSpecificationForTT2WithAuthHeader(id, token, path));
    }

    private static RequestSpecification requestSpecificationForTT2Main() {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }


    private static RequestSpecification requestSpecificationForTT2Gateway(String path) {
        return requestSpecificationForTT2Main()
                .baseUri(SpringApplicationContext.getProperty("api.base"))
                .basePath(path);
    }

    private static RequestSpecification requestSpecificationForTT2Gateway(Integer id, String path) {
        return requestSpecificationForTT2Main()
                .baseUri(SpringApplicationContext.getProperty("api.base"))
                .basePath(path + "/" + id);
    }

    private static RequestSpecification requestSpecificationForTT2WithAuthHeader(String token, String path) {
        return requestSpecificationForTT2Gateway(path)
                .header("Authorization", "Bearer " + token);
    }

    private static RequestSpecification requestSpecificationForTT2WithAuthHeader(Integer id, String token, String path) {
        return requestSpecificationForTT2Gateway(id, path)
                .header("Authorization", "Bearer " + token);
    }
}
