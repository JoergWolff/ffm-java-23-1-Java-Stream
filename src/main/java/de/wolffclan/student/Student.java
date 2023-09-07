package de.wolffclan.student;

import java.util.Objects;

public class Student {
    int id;
    String name;
    String postcode;
    int age;

    public Student() {
    }

    public Student(int id, String name, String postcode, int age) {
        this.id = id;
        this.name = name;
        this.postcode = postcode;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name) && Objects.equals(postcode, student.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, postcode, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postcode='" + postcode + '\'' +
                ", age=" + age +
                '}';
    }
}
