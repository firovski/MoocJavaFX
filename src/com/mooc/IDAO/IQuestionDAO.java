/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.IDAO;

import com.mooc.entities.Question;
import java.util.List;

/**
 *
 * @author Firas
 */
public interface IQuestionDAO {
    public void ajouter(Question q,int id);
    public Question getQuestion(int id);
    public void metreajour(Question t);
    public void supprimer(Question id);
    public Question rechercheid(int id);
    public List<Question> recherchenom(String id);
    public List<Question> recherchetype(String id);
    public List<Question> afficherQuestion();
    public List<Question> ListByQuiz(int id);
    
}
