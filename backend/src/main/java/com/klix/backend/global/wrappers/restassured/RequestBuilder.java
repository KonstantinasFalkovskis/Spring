package com.klix.backend.global.wrappers.restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.klix.backend.global.wrappers.IRequestBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

import java.io.File;
import java.util.List;
import java.util.Map;

@Getter()
@NoArgsConstructor
public class RequestBuilder implements IRequestBuilder {
    private final ObjectMapper mapper = new ObjectMapper();
    private RequestSpecification specification;
    private String specContentType;
    private Integer statusCode = HttpStatus.SC_OK;
    private String contentType = ContentType.JSON.toString();
    private String path = "";
    private String authToken;
    private String body;

    @Override
    public RequestBuilder setUrlEncoding(boolean value) {
        specification.urlEncodingEnabled(value);
        return this;
    }

    @Override
    public RequestBuilder header(String key, Object value) {
        specification.header(key, value);
        return this;
    }

    @Override
    public RequestBuilder header(Header header) {
        specification.header(header);
        return this;
    }

    @Override
    public RequestBuilder headers(Map<String, ?> map) {
        specification.headers(map);
        return this;
    }

    @Override
    public RequestBuilder queryParameter(String key, Object value) {
        this.specification.queryParam(key, value);
        return this;
    }

    @Override
    public RequestBuilder queryParameters(Map<String, Object> params) {
        this.specification.queryParams(params);
        return this;
    }

    @Override
    public RequestBuilder specification(RequestSpecification specification) {
        this.specification = specification;
        return this;
    }

    @Override
    public RequestBuilder body(String body) {
        this.body = body;
        return this;
    }

    @Override
    public RequestBuilder body(Object body) {
        try {
            this.body = mapper.writeValueAsString(body);
            return this;
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public RequestBuilder statusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    @Override
    public RequestBuilder contentType(ContentType contentType) {
        this.contentType = contentType.toString();
        return this;
    }

    @Override
    public RequestBuilder contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    @Override
    public RequestBuilder specContentType(ContentType contentType) {
        this.specContentType = contentType.toString();
        return this;
    }

    @Override
    public RequestBuilder specContentType(String contentType) {
        this.specContentType = contentType;
        return this;
    }

    @Override
    public <T> RequestBuilder path(T path) {
        String pathString = String.valueOf(path);
        if (!pathString.contains("/")) {
            pathString = addChar(pathString, '/', 0);
        }
        this.path = pathString;
        return this;
    }

    @Override
    public RequestBuilder authToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    @Override
    public RequestBuilder multiPart(String s, File file, String mediaType) {
        this.specification.multiPart(s, file, mediaType);
        return this;
    }

    @Override
    public Response post() {
        return returnResponse(Method.POST);
    }

    @Override
    public <T> T postReturnItem(Class<T> responseClass) {
        return returnItem(Method.POST, responseClass);
    }

    @Override
    public <T> T postReturnItem(String jsonKey, Class<T> responseClass) {
        return returnItem(Method.POST, jsonKey, responseClass);
    }

    @Override
    public <T> List<T> postReturnList(String jsonKey, Class<T> responseClass) {
        return returnList(Method.POST, jsonKey, responseClass);
    }

    @Override
    public <T> List<T> postReturnList(Class<T> responseClass) {
        return returnList(Method.POST, responseClass);
    }

    @Override
    public Response get() {
        return returnResponse(Method.GET);
    }

    @Override
    public <T> T getReturnItem(Class<T> responseClass) {
        return returnItem(Method.GET, responseClass);
    }

    @Override
    public <T> T getReturnItem(String jsonKey, Class<T> responseClass) {
        return returnItem(Method.GET, jsonKey, responseClass);
    }

    @Override
    public <T> List<T> getReturnList(String jsonKey, Class<T> responseClass) {
        return returnList(Method.GET, jsonKey, responseClass);
    }

    @Override
    public <T> List<T> getReturnList(Class<T> responseClass) {
        return returnList(Method.GET, responseClass);
    }

    @Override
    public Response put() {
        return returnResponse(Method.PUT);
    }

    @Override
    public Response patch() {
        return returnResponse(Method.PATCH);
    }

    @Override
    public <T> T putReturnItem(Class<T> responseClass) {
        return returnItem(Method.PUT, responseClass);
    }

    @Override
    public <T> T putReturnItem(String jsonKey, Class<T> responseClass) {
        return returnItem(Method.PUT, jsonKey, responseClass);
    }
    @Override
    public <T> T patchReturnItem(String jsonKey, Class<T> responseClass) {
        return returnItem(Method.PATCH, jsonKey, responseClass);
    }

    @Override
    public <T> List<T> putReturnList(String jsonKey, Class<T> responseClass) {
        return returnList(Method.PUT, jsonKey, responseClass);
    }

    @Override
    public Response delete() {
        return returnResponse(Method.DELETE);
    }

    @Override
    public <T> T deleteReturnItem(Class<T> responseClass) {
        return returnItem(Method.DELETE, responseClass);
    }

    @Override
    public <T> T deleteReturnItem(String jsonKey, Class<T> responseClass) {
        return returnItem(Method.DELETE, jsonKey, responseClass);
    }

    @Override
    public <T> List<T> deleteReturnList(String jsonKey, Class<T> responseClass) {
        return returnList(Method.DELETE, jsonKey, responseClass);
    }

    private Response returnResponse(Method method) {
        return returnResponse(buildParams(getSpecification()), method, getContentType(), getStatusCode());
    }

    private <T> T returnItem(Method method, Class<T> responseClass) {
        return returnResponseItem(
                buildParams(getSpecification()), method, responseClass, getContentType(), getStatusCode());
    }

    private <T> T returnItem(Method method, String jsonKey, Class<T> responseClass) {
        return returnResponseItem(
                buildParams(getSpecification()), method, jsonKey, responseClass, getContentType(), getStatusCode());
    }

    private <T> List<T> returnList(Method method, String jsonKey, Class<T> responseClass) {
        return returnResponseList(
                buildParams(getSpecification()), method, responseClass, getContentType(), getStatusCode(),
                jsonKey
        );
    }

    private <T> List<T> returnList(Method method, Class<T> responseClass) {
        return returnResponseList(
                buildParams(getSpecification()), method, responseClass, getContentType(), getStatusCode(),
                "items"
        );
    }

    private Response returnResponse(
            RequestSpecification specification, Method method, String contentType, Integer statusCode
    ) {
        return insertRestMethod(specification, method)
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .assertThat()
                .statusCode(statusCode)
                .contentType(contentType)
                .extract()
                .response();
    }

    private <T> T returnResponseItem(
            RequestSpecification specification, Method method, Class<T> responseClass, String contentType,
            Integer statusCode
    ) {
        return insertRestMethod(specification, method)
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .assertThat()
                .statusCode(statusCode)
                .contentType(contentType)
                .extract()
                .as(responseClass);
    }

    private <T> T returnResponseItem(
            RequestSpecification specification, Method method, String jsonKey, Class<T> responseClass,
            String contentType,
            Integer statusCode
    ) {
        return insertRestMethod(specification, method)
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .assertThat()
                .statusCode(statusCode)
                .contentType(contentType)
                .extract()
                .jsonPath()
                .getObject(jsonKey, responseClass);
    }

    private <T> List<T> returnResponseList(
            RequestSpecification specification, Method method, Class<T> responseClass, String contentType,
            Integer statusCode, String jsonKey
    ) {
        return insertRestMethod(specification, method)
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .assertThat()
                .statusCode(statusCode)
                .contentType(contentType)
                .extract()
                .jsonPath()
                .getList(jsonKey, responseClass);
    }

    private RequestSpecification buildParams(RequestSpecification specification) {
        if (getAuthToken() != null) {
            specification.auth().oauth2(getAuthToken());
        }
        if (getBody() != null) {
            specification.body(getBody());
        }
        if (getSpecContentType() != null) {
            specification.contentType(getSpecContentType());
        }
        return specification;
    }

    private Response insertRestMethod(RequestSpecification spec, Method method) {
        spec = spec.log().ifValidationFails(LogDetail.ALL);
        switch (method) {
            case GET:
                return spec.get(getPath());
            case PUT:
                return spec.put(getPath());
            case PATCH:
                return spec.patch(getPath());
            case DELETE:
                return spec.delete(getPath());
            case POST:
                return spec.post(getPath());
            default:
                return null;
        }
    }

    private String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }

    private enum Method {
        POST,
        GET,
        PUT,
        DELETE,
        PATCH
    }

    @Getter
    private static class QueryParam {
        private final String key;
        private final Object value;

        private QueryParam(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
