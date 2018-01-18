package com.redhat.example.web;

import javax.enterprise.inject.Model;

import com.redhat.example.model.Person2;

@Model
public class PersonForm extends Person2 {

    public Person2 toEntity() {
        return new Person2(getId(), getFirstName(), getLastName(), getAge(), getMobile(), getNickname());
    }

    public void setEntity(Person2 p) {
        setId(p.getId());
        setFirstName(p.getFirstName());
        setLastName(p.getLastName());
        setAge(p.getAge());
        setMobile(p.getMobile());
        setNickname(p.getNickname());
    }

}
