package org.nutritionist.patient;

public class Patient {
    private String name;
    private String age;
    private String weight;
    private String height;

    public Patient(String name, String age, String weight, String height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String toString(){
        return "Patient Data: \n" +
                "Name:" + name + "\n"+
                "Age:" + age + "\n"+
                "Weight: " + weight + "\n"+
                "Height: " + height + "\n"+
                "Prueba";
    }
}
