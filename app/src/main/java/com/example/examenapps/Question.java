package com.example.examenapps;

public class Question {

    private int numQ;
    private int question;
    private int qSelect;

    public Question(int numQ, int question, int qSelect) {
        this.numQ = numQ;
        this.question = question;
        this.qSelect = qSelect;
    }

    public int getNumQ() {
        return numQ;
    }

    public void setNumQ(int numQ) {
        this.numQ = numQ;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getqSelect() {
        return qSelect;
    }

    public void setqSelect(int qSelect) {
        this.qSelect = qSelect;
    }
}
