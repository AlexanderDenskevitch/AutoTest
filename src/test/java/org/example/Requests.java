package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.io.*;
import java.net.*;

public class Requests {
    private static HttpURLConnection connection;

    public static void getAllPosts() {
        {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                int status = connection.getResponseCode();
                System.out.println(status);
                System.out.println(ResponseReader.parseUrl(url));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getOnePost(int postNumber) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/" + postNumber);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            System.out.println(status);
            System.out.println(ResponseReader.parseUrl(url));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    public static void postNewPost() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Dance_example");
        requestBody.put("body", "example_body");
        requestBody.put("userId", "1");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json; charset=UTF-8");
        request.body(requestBody.toJSONString());
        Response response = request.post("https://jsonplaceholder.typicode.com/posts");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
        System.out.println("The status code recieved: " + statusCode);
        System.out.println((String) response.jsonPath().getString("$"));

    }

    public static void getUsers() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            System.out.println(status);
            System.out.println(ResponseReader.parseUrl(url));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    public static void getOneUser(int userNumber) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users/" + userNumber);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            System.out.println(status);
            System.out.println(ResponseReader.parseUrl(url));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

}
