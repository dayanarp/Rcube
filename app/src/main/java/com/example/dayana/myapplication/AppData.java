package com.example.dayana.myapplication;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dayana on 11/21/16.
 */

public class AppData {

    private static List<User> userList;
    private static HashMap<String, User> userString;
    private static HashMap<String,String> users;
    private static HashMap<String, String> usersType;
    private static List<Agreement> agreementList;
    private static User currentU;
    private static String[] cities = {"Select City","Caracas", "Valencia", "Barcelona", "Pto. La Cruz", "Maracaibo"};
    private static String[] materials = {"Select Material","Papel", "Plastico", "Vidrio"};
    private static String[] quant = {"Select Quantity","10", "20", "35", "50", "70", "100"};
    private static String[] unit = {"Select Unit of messure","Kgs", "Lts", "Units"};

    public static List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        AppData.userList = userList;
    }

    public static HashMap<String, String> getUsers() {
        return users;
    }

    public static void setUsers(HashMap<String, String> users) {
        AppData.users = users;
    }

    public static HashMap<String, String> getUsersType() {
        return usersType;
    }

    public static void setUsersType(HashMap<String, String> usersType) {
        AppData.usersType = usersType;
    }

    public static List<Agreement> getAgreementList() {
        return agreementList;
    }

    public static void setAgreementList(List<Agreement> agreementList) {
        AppData.agreementList = agreementList;
    }

    public static User getCurrentU() {
        return currentU;
    }

    public static void setCurrentU(User currentU) {
        AppData.currentU = currentU;
    }

    public static HashMap<String, User> getUserString() {
        return userString;
    }

    public static void setUserString(HashMap<String, User> userString) {
        AppData.userString = userString;
    }

    public static String[] getCities() {
        return cities;
    }

    public static String[] getMaterials() {
        return materials;
    }

    public static void setCities(String[] cities) {
        AppData.cities = cities;
    }

    public static void setMaterials(String[] materials) {
        AppData.materials = materials;
    }

    public static String[] getQuant() {
        return quant;
    }

    public static String[] getUnit() {
        return unit;
    }

    public static void setQuant(String[] quant) {
        AppData.quant = quant;
    }

    public static void setUnit(String[] unit) {
        AppData.unit = unit;
    }
}
