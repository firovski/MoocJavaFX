/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.DAO;

import com.mooc.IDAO.IReponseDAO;
import com.mooc.Util.MyConnexion;
import com.mooc.entities.Question;
import com.mooc.entities.Reponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Firas
 */
public class ReponseDAO implements IReponseDAO {
    


    private Connection cnx;
    private PreparedStatement prepared;

    public ReponseDAO() {
        cnx = new MyConnexion().connection();
    }

    @Override
    public void ajouter(Reponse q,int id) {
        String req = "insert into reponse (reponsetext,reponsecorrecttext,reponsecorrectradio,idquestion) values (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, q.getReponsetext());
            ps.setString(2, q.getReponsecorrecttext());
            ps.setBoolean(3, q.isReponsecorrectradio());
            ps.setInt(4, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Reponse getReponse(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reponse> afficherReponse() {
        List<Reponse> listquiz = new ArrayList<>();
        String requete = "select * from reponse";
        try {
            Statement ps;
            ps = cnx.createStatement();
            ResultSet resultat;
            resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Reponse quiz = new Reponse();
                quiz.setID(resultat.getInt(1));
                quiz.setReponsetext(resultat.getString(2));
                quiz.setReponsecorrecttext(resultat.getString(3));
                quiz.setReponsecorrectradio(resultat.getBoolean(4));
                quiz.setQuestion(resultat.getInt(5));
               
                listquiz.add(quiz);
            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des quiz " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void metreajour(Reponse t) {
        String req = "UPDATE `reponse` SET `reponsetext`=?,`reponsecorrecttext`=?,`reponsecorrectradio`=?,`idquestion`=? where id=?";
        try {
            prepared = cnx.prepareStatement(req);

            prepared.setString(1, t.getReponsetext());
            prepared.setString(2, t.getReponsecorrecttext());
            prepared.setBoolean(3, t.isReponsecorrectradio());
            prepared.setInt(4, t.getQuestion());
          


            prepared.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimer(Reponse id) {
        String requete = "delete from question where id=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setInt(1, id.getID());
            prepared.executeUpdate();
            System.out.println("Question supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }

    }

    @Override
    public Reponse rechercheid(int id) {

        Reponse quiz = new Reponse();
        String requete = "select * from reponse where id=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setInt(1, id);

            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setReponsetext(resultat.getString(2));
                quiz.setReponsecorrecttext(resultat.getString(3));
                quiz.setReponsecorrectradio(resultat.getBoolean(4));
                quiz.setQuestion(resultat.getInt(5));
               

            }
            return quiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }

    }

    @Override
    public List<Reponse> recherchenom(String id) {
        List<Reponse> listquiz = new ArrayList<>();

        Reponse quiz = new Reponse();
        String requete = "select * from reponse where quiznom=?";
        try {
            prepared.setString(1, id);

            prepared = cnx.prepareStatement(requete);

            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setReponsetext(resultat.getString(2));
                quiz.setReponsecorrecttext(resultat.getString(3));
                quiz.setReponsecorrectradio(resultat.getBoolean(4));
                quiz.setQuestion(resultat.getInt(5));
                listquiz.add(quiz);

            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Reponse> recherchetype(String id) {
        Reponse quiz = new Reponse();
        List<Reponse> listquiz = new ArrayList<>();

        String requete = "select * from reponse where type=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setString(1, id);
            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setReponsetext(resultat.getString(2));
                quiz.setReponsecorrecttext(resultat.getString(3));
                quiz.setReponsecorrectradio(resultat.getBoolean(4));
                quiz.setQuestion(resultat.getInt(5));
                listquiz.add(quiz);

            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Reponse> ListByQuestion(int id) {
        List<Reponse> listquiz = new ArrayList<>();
        String requete = "select * from reponse where idquestion=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setString(1, Integer.toString(id));
            ResultSet resultat = prepared.executeQuery();

            while (resultat.next()) {
                Reponse quiz = new Reponse();
                quiz.setID(resultat.getInt(1));
                quiz.setReponsetext(resultat.getString(2));
                quiz.setReponsecorrecttext(resultat.getString(3));
                quiz.setReponsecorrectradio(resultat.getBoolean(4));
                quiz.setQuestion(resultat.getInt(5));
                listquiz.add(quiz);
            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des quiz " + ex.getMessage());
            return null;
        }
}
    
    

    
    
    
    
}

