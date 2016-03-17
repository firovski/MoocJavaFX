/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc;

import com.mooc.DAO.QuizDAO;
import com.mooc.entities.Quiz;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Firas
 */
public class firas {
    public static void main(String[] args) {
        List<Quiz> list; 
        Quiz q = new Quiz(30, "bbbbbbb", "aaa", "12/12/2012", "aaa", "aaa", 4, 2);
        QuizDAO qdqo = new QuizDAO();
        //qdqo.ajouter(q);
        //list=qdqo.recherchetype("Final");
        //list=qdqo.afficherquiz();
        //list=qdqo.recherchenom("quiz22");
        //list.stream().forEach(e->System.out.println(e));
        //System.out.println(list.size());
        //qdqo.supprimer(q);
        Quiz q1=qdqo.rechercheid(10);
        System.out.println(q1);
        
    }
    
}
