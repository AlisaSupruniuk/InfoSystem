package by.kursovoi.bntu.supruniuk.infosystem.models;

public class User {
    private String surname, name, phone, email, gender;
    private int _id, year, apartment;
    public  User(){}

    public  User(int id, String surname, String name, String gender, int year, int apartment,
                 String phone, String email){
        this._id = id;
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.phone = phone;
        this.apartment = apartment;
        this.email = email;
    }

    //получаем значение
    public String getSurname() {
        return surname;
    }
    //устанавливаем значение
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public  int getId(){
        return this._id;
    }

    public void setId(int id){
        this._id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {

        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
}
