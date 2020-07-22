package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Qas {
    //主键
    @Id
    @GeneratedValue
    private int id;

    //问题内容
    private String question;

    //答案内容
    private String answer;

    //答案起始位置
    private int start;

    //外键
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    private Context context;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
