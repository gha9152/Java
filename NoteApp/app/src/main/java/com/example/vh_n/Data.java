package com.example.vh_n;

public class Data {

    public String Name;
    public String Family;
    public String age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int id;

    public Data(String name, String family, String age, int id) {
        Name = name;
        Family = family;
        this.age = age;
        this.id = id;
    }
}
