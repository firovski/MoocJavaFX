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
public class Assignement {
    
    private int ID;
    private int score;
    private int badge;
    private int quiz;
    private int user;

    public Assignement() {
    }

    public Assignement(int ID, int score, int badge, int quiz, int user) {
        this.ID = ID;
        this.score = score;
        this.badge = badge;
        this.quiz = quiz;
        this.user = user;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Assignement{" + "ID=" + ID + ", score=" + score + ", badge=" + badge + ", quiz=" + quiz + ", user=" + user + '}';
    }
    
    
    
    
}
