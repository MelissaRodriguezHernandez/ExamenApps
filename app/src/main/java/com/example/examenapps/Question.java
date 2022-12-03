package com.example.examenapps;

public class Question {

    private int num;
    private int question;
    private int qSelect;

    public Question(int numQ, int questionQ, int qSelectQ) {
        num = numQ;
       question = questionQ;
        qSelect = qSelectQ;
    }

    public int getNumQ() {
        return num;
    }

    public void setNumQ(int numQ) {
        num = numQ;
    }

    public int getQuestionQ() {
        return question;
    }

    public void setQuestionQ(int questionQ) {
        question = questionQ;
    }

    public int getqSelectQ() {
        return qSelect;
    }

    public void setqSelectQ(int qSelectQ) {
        qSelect = qSelectQ;
    }
}
