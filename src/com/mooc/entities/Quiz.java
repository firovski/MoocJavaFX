/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.entities;

import java.sql.Date;



/**
 *
 * @author Firas
 */
public class Quiz {
    private int ID;
    private String quiznom;
    private String quizdescription;
    private String dateajout;
    private String intro;
    private String type;
    private int duree;
    private int cour;

    public Quiz() {
    }
    

    public Quiz(int ID, String quiznom, String quizdescription, String dateajout, String intro, String type, int duree, int cour) {
        this.ID = ID;
        this.quiznom = quiznom;
        this.quizdescription = quizdescription;
        this.dateajout = dateajout;
        this.intro = intro;
        this.type = type;
        this.duree = duree;
        this.cour = cour;
    }
    
    
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuiznom() {
        return quiznom;
    }

    public void setQuiznom(String quiznom) {
        this.quiznom = quiznom;
    }

    public String getQuizdescription() {
        return quizdescription;
    }

    public void setQuizdescription(String quizdescription) {
        this.quizdescription = quizdescription;
    }

    public String getDateajout() {
        return dateajout;
    }

    public void setDateajout(String dateajout) {
        this.dateajout = dateajout;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getCour() {
        return cour;
    }

    public void setCour(int cour) {
        this.cour = cour;
    }

    @Override
    public String toString() {
        return "Quiz{" + "ID=" + ID + ", quiznom=" + quiznom + ", quizdescription=" + quizdescription + ", dateajout=" + dateajout + ", intro=" + intro + ", type=" + type + ", duree=" + duree + ", cour=" + cour + '}';
    }
    
    
    
    
}
