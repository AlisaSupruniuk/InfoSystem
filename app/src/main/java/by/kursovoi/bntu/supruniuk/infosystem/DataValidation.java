package by.kursovoi.bntu.supruniuk.infosystem;

public class DataValidation {
    boolean valid = true;

    public boolean emptyFieldSurname(String surname) {
        if (surname.equals("") || surname.length()<2 || surname.length()>30) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;

    }

    public boolean emptyFieldName(String name) {

        if (name.equals("") || name.length()<2 || name.length()>30) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public boolean emptyFieldGender(String gender) {
        String man = "муж";
        String woman = "жен";
        if ((gender.equals("") || !gender.equals(man) && !gender.equals(woman))) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public boolean emptyFieldYear(String year) {
        if (year.equals("") || Integer.parseInt(year) < 1900 || Integer.parseInt(year) > 2020) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public boolean emptyFieldApartment(String apartment) {
        if (apartment.equals("") || Integer.parseInt(apartment) < 1 || Integer.parseInt(apartment) > 19) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public boolean emptyFieldPhone(String phone) {
        if (phone.equals("") || phone.length() != 9) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    public boolean emptyFieldEmail(String email) {
        if (!(email.length() < 41)) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;

    }
}
