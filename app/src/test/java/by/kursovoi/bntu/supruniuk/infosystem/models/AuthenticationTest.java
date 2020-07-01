package by.kursovoi.bntu.supruniuk.infosystem.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticationTest {

    Authentication auth;

    {
        auth = new Authentication();
    }

    @Test
    public void validate_InputEmailAndPassword_True() {
        String email = "alisa";
        String password = "alisa";

        Boolean expectation = true;
        Boolean actual = auth.validate(email, password);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void validate_InputEmailAndPassword_False() {
        String email = "12345";
        String password = "qwert";

        Boolean expectation = false;
        Boolean actual = auth.validate(email, password);

        Assert.assertEquals(expectation, actual);
    }

}