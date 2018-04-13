package model;

import controller.command.constants.RegexExpressions;
import model.exception.WrongFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String phone;
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.birthDay = dateFormat.parse(birthDay);
        } catch (ParseException ignored){}
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "name=" + firstName + ' ' + lastName +
                ", birth day=" + birthDay.getDate() + '-' + birthDay.getMonth() + '-' + birthDay.getYear() +
                ", phone=" + phone +
                ", address=" + address;
    }
}
