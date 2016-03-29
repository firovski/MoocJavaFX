/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.IDAO;

import com.mooc.entities.Question;
import com.mooc.entities.Reponse;
import java.util.List;

/**
 *
 * @author Firas
 */
public interface IReponseDAO {
    public void ajouter(Reponse q,int idquestion);
    public Reponse getReponse(int id);
    public void metreajour(Reponse t);
    public void supprimer(Reponse id);
    public Reponse rechercheid(int id);
    public List<Reponse> recherchenom(String id);
    public List<Reponse> recherchetype(String id);
    public List<Reponse> afficherReponse();
    public List<Reponse> ListByQuestion(int id);

    
}
