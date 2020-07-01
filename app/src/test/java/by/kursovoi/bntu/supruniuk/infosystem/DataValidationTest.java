package by.kursovoi.bntu.supruniuk.infosystem;

import org.junit.Assert;
import org.junit.Test;

import by.kursovoi.bntu.supruniuk.infosystem.models.Authentication;

import static org.junit.Assert.*;

public class DataValidationTest {

    DataValidation dv;

    {
        dv = new DataValidation();
    }

    @Test
    public void emptyFieldSurname_InputSurname_True() {

        String surname = "Supruniuk";

        Boolean expectation = true;
        Boolean actual = dv.emptyFieldSurname(surname);

        Assert.assertEquals(expectation, actual);

    }

    @Test
    public void emptyFieldSurname_InputSurname_False() {

        String surname = "S";

        Boolean expectation = false;
        Boolean actual = dv.emptyFieldSurname(surname);

        Assert.assertEquals(expectation, actual);

    }

    @Test
    public void emptyFieldName_InputName_True() {
        String name = "Alisa";

        Boolean expectation = true;
        Boolean actual = dv.emptyFieldName(name);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldName_InputName_False() {
        String name = "V";

        Boolean expectation = false;
        Boolean actual = dv.emptyFieldName(name);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldGender_InputGender_True() {
        String gender = "жен";

        Boolean expectation = true;
        Boolean actual = dv.emptyFieldGender(gender);

        Assert.assertEquals(expectation, actual);
    }
    @Test
    public void emptyFieldGender_InputGender_False() {
        String gender = "12";

        Boolean expectation = false;
        Boolean actual = dv.emptyFieldGender(gender);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldYear_InputYear_true() {
        String year = "1900";

        Boolean expectation = true;
        Boolean actual = dv.emptyFieldYear(year);

        Assert.assertEquals(expectation, actual);
    }
    @Test
    public void emptyFieldYear_InputYear_False() {
        String year = "2031";

        Boolean expectation = false;
        Boolean actual = dv.emptyFieldYear(year);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldApartment_InputApartment_True() {
        String apartment = "13";

        Boolean expectation = true;
        Boolean actual = dv.emptyFieldApartment(apartment);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldApartment_InputApartment_False() {
        String apartment = "20";

        Boolean expectation = false;
        Boolean actual = dv.emptyFieldApartment(apartment);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldPhone_InputPhone_True() {
        String phone = "123456789";

        Boolean expectation = true;
        Boolean actual = dv.emptyFieldPhone(phone);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldPhone_InputPhone_False() {
        String phone = "";

        Boolean expectation = false;
        Boolean actual = dv.emptyFieldPhone(phone);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldEmail_InputEmail_True() {
        String email = "";

        Boolean expectation = true;
        Boolean actual = dv.emptyFieldEmail(email);

        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void emptyFieldEmail_InputEmail_False() {
        String email = "asdfghjkl;'][poiuytrewqazxcvbnm,./';lkjhgf";

        Boolean expectation = false;
        Boolean actual = dv.emptyFieldEmail(email);

        Assert.assertEquals(expectation, actual);
    }
}