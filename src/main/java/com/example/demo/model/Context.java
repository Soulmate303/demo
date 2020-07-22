package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Context {
    //主键
    @Id
    @GeneratedValue
    private int id;

    //文本内容
    private String context_text;

    @OneToMany(mappedBy = "context",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Qas> qasList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext_text() {
        return context_text;
    }

    public void setContext_text(String context_text) {
        this.context_text = context_text;
    }
}
