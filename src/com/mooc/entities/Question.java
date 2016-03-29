/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Firas
 */
public class Question {
    private int ID;
    private String questiontext;
    private String type;
    private int point;
    private int quiz;
    private List<Reponse> listreponse;

    public Question() {
    }

    public Question(int ID, String questiontext, String type, int point, int quiz) {
        this.ID = ID;
        this.questiontext = questiontext;
        this.type = type;
        this.point = point;
        this.quiz = quiz;
        this.listreponse= new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public List<Reponse> getListreponse() {
        return listreponse;
    }

    public void setListreponse(List<Reponse> listreponse) {
        this.listreponse = listreponse;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Question{" + "ID=" + ID + ", questiontext=" + questiontext + ", type=" + type + ", point=" + point + ", quiz=" + quiz + '}';
    }
    
    
    
    
}
