/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.IDAO;

import com.mooc.entities.Assignement;
import java.util.List;

/**
 *
 * @author Firas
 */
public interface IAssignementDAO {
    public void ajouter(Assignement q);
    public Assignement getAssignement(int id);
    public void metreajour(Assignement t);
    public void supprimer(Assignement id);
    public Assignement rechercheid(int id);
    public List<Assignement> recherchenom(String id);
    public List<Assignement> recherchetype(String id);
    public List<Assignement> afficherAssignement();
    
}
