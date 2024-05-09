package utils;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static io.restassured.RestAssured.given;

public class RestUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestUtils.class);
    public static RequestSpecification requestSpecification;
    public static Response response;

    public JsonObject readJsonFile() throws IOException {
        String jsonFilePath = ConfigUtils.getProperties("request_model_path") + "post_request.json";
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(new FileReader(jsonFilePath));
        return jsonElement.getAsJsonObject();
    }

    public static void setBaseUrl(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        requestSpecification = given();
        LOGGER.info("Sending request to endpoint: {}", RestAssured.baseURI);
    }

    public static void setBasePath(String basePath) {
        RestAssured.basePath = basePath;
        requestSpecification = given();
        LOGGER.info("Sending request to endpoint: {}", RestAssured.basePath);
    }

    public static void setContentType(String contentType) {
        requestSpecification.header(new Header("Content-type", contentType));
    }

    public static void performPostRequest() throws IOException {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        JsonObject bodyPayload = new RestUtils().readJsonFile();
        requestSpecification.body(bodyPayload.toString());
        response = requestSpecification.post();
        response.then().log().all();
        printLog(RestAssured.baseURI + RestAssured.basePath, response);
    }

    public static Response performPostRequestWithQuery(String queryValue) {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        requestSpecification.queryParam(ConfigUtils.getProperties("query_string_path"), queryValue);
        response = requestSpecification.post();
        response.then().log().all();
        printLog(RestAssured.baseURI + RestAssured.basePath, response);
        return response;
    }

    public static Response performGetRequest() {
        response = requestSpecification.when().get();
        response.then().log().all();
        printLog(RestAssured.baseURI + RestAssured.basePath, response);
        return response;
    }

    public static void printLog(String endpoint, Response response) {
        LOGGER.info("URL: {}", endpoint);
        LOGGER.info("Received response status code: {}", response.getStatusCode());
    }
}