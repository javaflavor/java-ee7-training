package com.redhat.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.redhat.example.constants.MessageRefs;
import com.redhat.example.util.ModelBase;
import com.redhat.example.validator.CheckCase;

@Entity
public class Person2 extends ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String firstName;

    private String lastName;

    private int age;

    private String mobile;

    private String nickname;

    public Person2() {
    }

    public Person2(String id, String firstName, String lastName, int age,
            String mobile, String nickname) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mobile = mobile;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @CheckCase(CheckCase.Mode.UPPER)
//    @NotNull(message="{com.redhat.example.model.Person.firstName.required}")
    @NotNull(message=MessageRefs.FIRST_NAME_REQUIRED)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    @NotNull(message="{com.redhat.example.model.Person.firstName.required}")
    @NotNull(message=MessageRefs.LAST_NAME_REQUIRED)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Max(value=100, message="Age は {value} 以下の数値で入力してください。")
    @Min(value=20, message="Age は {value} 以上の数値で入力してください。")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Pattern(regexp="(090|080|070)-[0-9]{4}-[0-9]{4}", message="Mobile には携帯電話番号をハイフン付で入力してください。ex.090-0123-4567")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Size(min=5, max=10, message="Nickname は {min} 文字以上、{max} 文字以下で入力してください。")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
