package com.redhat.example.web;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.redhat.example.business.PersonService;
import com.redhat.example.model.Person2;

@Model
public class PersonBean {

    @Inject
    private PersonForm form;

    @Inject
    private PersonService service;

    public String create() {

        Person2 e = form.toEntity();

        service.create(e);

        return "index.xhtml";
    }

    public String edit(Person2 e) {
        Person2 p = service.find(e.getId());
        form.setEntity(p);
        return "edit.xhtml";
    }

    public String update() {
        Person2 e = form.toEntity();
        service.update(e);
        return "index.xhtml";
    }

    public String delete(Person2 e) {
        Person2 p = service.find(e.getId());
        form.setEntity(p);
        return "delete.xhtml";
    }

    public String delete() {
        String id = form.getId();
        service.remove(id);
        return "index.xhtml";
    }

}
