/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.entities;

/**
 *
 * @author Firas
 */
public class Reponse {
    
    private int ID;
    private String reponsetext;
    private String reponsecorrecttext;
    private boolean reponsecorrectradio;
    private Question question;

    public Reponse() {
    }

    public Reponse(int ID, String reponsetext, String reponsecorrecttext, boolean reponsecorrectradio, Question question) {
        this.ID = ID;
        this.reponsetext = reponsetext;
        this.reponsecorrecttext = reponsecorrecttext;
        this.reponsecorrectradio = reponsecorrectradio;
        this.question = question;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getReponsetext() {
        return reponsetext;
    }

    public void setReponsetext(String reponsetext) {
        this.reponsetext = reponsetext;
    }

    public String getReponsecorrecttext() {
        return reponsecorrecttext;
    }

    public void setReponsecorrecttext(String reponsecorrecttext) {
        this.reponsecorrecttext = reponsecorrecttext;
    }

    public boolean isReponsecorrectradio() {
        return reponsecorrectradio;
    }

    public void setReponsecorrectradio(boolean reponsecorrectradio) {
        this.reponsecorrectradio = reponsecorrectradio;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Reponse{" + "ID=" + ID + ", reponsetext=" + reponsetext + ", reponsecorrecttext=" + reponsecorrecttext + ", reponsecorrectradio=" + reponsecorrectradio + ", question=" + question + '}';
    }
    
    
    
    
}
