package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tenant")
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name= "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="note" , columnDefinition = "text")
    private  String note;

    public void setNote(String note) {
        this.note = note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
