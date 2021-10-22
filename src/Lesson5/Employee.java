package Lesson5;

public class Employee {

    private String fullName;
    private String positon;
    private String email;
    private int telephone;
    private int theSalary;
    protected int age;

    public Employee(String fullName, String positon, String email, int telephone, int theSalary, int age) {
        this.fullName = fullName;
        this.positon = positon;
        this.email = email;
        this.telephone = telephone;
        this.theSalary = theSalary;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void printInfo() {

        System.out.println("fullName: " + fullName + " positon: " + positon + " email: " + email + " telephone: "
                + telephone + " theSalary: " + theSalary + " age: " + age);

    }


}






