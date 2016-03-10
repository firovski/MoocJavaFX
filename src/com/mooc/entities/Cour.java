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
public class Cour {
    private int ID;

    public Cour(int ID) {
        this.ID = ID;
    }

    public Cour() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Cour{" + "ID=" + ID + '}';
    }
    
    
    
}
