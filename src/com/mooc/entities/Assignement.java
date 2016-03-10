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
    private Badge badge;
    private Quiz quiz;
    private User user;

    public Assignement() {
    }

    public Assignement(int ID, int score, Badge badge, Quiz quiz, User user) {
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

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Assignement{" + "ID=" + ID + ", score=" + score + ", badge=" + badge + ", quiz=" + quiz + ", user=" + user + '}';
    }
    
    
    
    
}
