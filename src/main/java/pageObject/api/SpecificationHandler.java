package pageObject.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationHandler {
    public static RequestSpecification requestSpec
            = new RequestSpecBuilder()
            .addHeader("Authorization", "")
            .setAccept(ContentType.JSON)
            .build()
            .filter(new AllureRestAssured());
    public static ResponseSpecification responseSpecCode200 =
            new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectContentType(ContentType.JSON)
                    .build();
    public static ResponseSpecification responseSpecCode401 =
            new ResponseSpecBuilder()
                    .expectStatusCode(401)
                    .expectContentType(ContentType.JSON)
                    .build();
    BasicAuthScheme auth = new BasicAuthScheme();
}
