package com.klix.backend.global.wrappers;

import com.klix.backend.global.wrappers.restassured.RequestBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface IRequestBuilder {

    RequestBuilder setUrlEncoding(boolean value);

    RequestBuilder queryParameter(String key, Object value);

    RequestBuilder queryParameters(Map<String, Object> params);

    RequestBuilder specification(RequestSpecification specification);

    RequestBuilder multiPart(String s, File file, String mediaType);

    RequestBuilder body(String body);

    RequestBuilder body(Object body);

    RequestBuilder header(String key, Object value);

    RequestBuilder header(Header header);

    RequestBuilder headers(Map<String, ?> headers);

    RequestBuilder statusCode(Integer statusCode);

    RequestBuilder contentType(ContentType contentType);

    RequestBuilder contentType(String contentType);

    RequestBuilder specContentType(ContentType contentType);

    RequestBuilder specContentType(String contentType);

    <T> RequestBuilder path(T path);

    RequestBuilder authToken(String authToken);

    Response post();

    <T> T postReturnItem(Class<T> responseClass);

    <T> T postReturnItem(String jsonKey, Class<T> responseClass);

    <T> List<T> postReturnList(String jsonKey, Class<T> responseClass);

    <T> List<T> postReturnList(Class<T> responseClass);

    Response get();

    <T> T getReturnItem(Class<T> responseClass);

    <T> T getReturnItem(String jsonKey, Class<T> responseClass);

    <T> List<T> getReturnList(String jsonKey, Class<T> responseClass);

    <T> List<T> getReturnList(Class<T> responseClass);

    Response put();

    Response patch();

    <T> T putReturnItem(Class<T> responseClass);

    <T> T putReturnItem(String jsonKey, Class<T> responseClass);

    <T> T patchReturnItem(String jsonKey, Class<T> responseClass);

    <T> List<T> putReturnList(String jsonKey, Class<T> responseClass);

    Response delete();

    <T> T deleteReturnItem(Class<T> responseClass);

    <T> T deleteReturnItem(String jsonKey, Class<T> responseClass);

    <T> List<T> deleteReturnList(String jsonKey, Class<T> responseClass);
}
