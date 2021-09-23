package org.example;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.example.Requests.*;

public class RestAPI {
    @Test
    public void mainTest() throws UnsupportedEncodingException {
        getAllPosts();
        getOnePost(99);
        getOnePost(150);
        postNewPost();
        getUsers();
        getOneUser(5);
    }
}
