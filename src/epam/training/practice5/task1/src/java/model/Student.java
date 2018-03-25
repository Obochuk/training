package model;

import model.constants.RegexExpressions;
import model.exception.WrongFormatException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String phone;
    private String address;
    private String street;
    private int house;
    private int apartment;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws WrongFormatException {
        if (firstName.matches(RegexExpressions.FULL_NAME_EXPR)) {
            this.firstName = firstName;
        }
        else {
            throw new WrongFormatException("Wrong format of name, given=" + firstName);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws WrongFormatException {
        if (lastName.matches(RegexExpressions.FULL_NAME_EXPR)) {
            this.lastName = lastName;
        }
        else {
            throw new WrongFormatException("Wrong format of name, given=" + lastName);
        }
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) throws WrongFormatException {
        if (birthDay.matches(RegexExpressions.DATE_EXPR)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                this.birthDay = dateFormat.parse(birthDay);
            } catch (Exception ignored){}
        }
        else {
            throw new WrongFormatException("Wrong format of date, given=" + birthDay + ", needed='dd-mm-yyyy'");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws WrongFormatException {
        if (phone.matches(RegexExpressions.PHONE_EXPR)) {
            this.phone = phone;
        }
        else {
            throw new WrongFormatException("Wrong format of phone, given=" + phone);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws WrongFormatException {
        Pattern pattern = Pattern.compile(RegexExpressions.ADDRESS_EXPR);
        Matcher matcher = pattern.matcher(address);
        if (matcher.matches()){
            this.address = address;
            house = Integer.parseInt(matcher.group(1));
            street = matcher.group(2);
            apartment = Integer.parseInt(matcher.group(3));
        }
        else {
            throw new WrongFormatException("Wrong format of address, given=" + address +
                    ", needed='house number street apartment number'");
        }
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "name=" + firstName + ' ' + lastName +
                ", birth day=" + birthDay.getDate() + '-' + birthDay.getMonth() + '-' + birthDay.getYear() +
                ", phone=" + phone +
                ", address=" + address;
    }
}
