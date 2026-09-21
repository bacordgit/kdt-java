package chapter02.lesson03;

public class Human {
    private String name;
    private int age;
    private boolean gender;

    public Human(int age, boolean gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
