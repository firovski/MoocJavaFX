/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.IDAO;
import com.mooc.entities.Quiz;
import java.util.List;

/**
 *
 * @author Firas
 */
public interface IQuizDAO {
    public void ajouter(Quiz q);
    public Quiz getquiz(int id);
    public void metreajour(Quiz t);
    public void supprimer(Quiz id);
    public Quiz rechercheid(int id);
    public List<Quiz> recherchenom(String id);
    public List<Quiz> recherchetype(String id);
    public List<Quiz> afficherquiz();
    
}
