package com.example.oscarhg1.quiz;

public class PreguntaTest
{
private String text;
private String[] respuestas;
private int correct;

    public PreguntaTest(String text, String[] respuestas, int correct) {
        this.text = text;
        this.respuestas = respuestas;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public int getCorrect() {
        return correct;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
