/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.DAO;

import com.mooc.IDAO.IAssignementDAO;
import com.mooc.Util.MyConnexion;
import com.mooc.entities.Assignement;
import com.mooc.entities.Question;
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
public class AssignementDAO implements IAssignementDAO {
    


    private Connection cnx;
    private PreparedStatement prepared;

    public AssignementDAO() {
        cnx = new MyConnexion().connection();
    }
    @Override
    public void ajouter(Assignement q) {
        String req = "insert into assignement (score,idbadge,iduser,idquiz) values (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, q.getScore());
            ps.setInt(2, q.getBadge());
            ps.setInt(3, q.getUser());
            ps.setInt(4, q.getQuiz());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Assignement getAssignement(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Assignement> afficherAssignement() {
        List<Assignement> listquiz = new ArrayList<>();
        String requete = "select * from assignement";
        try {
            Statement ps;
            ps = cnx.createStatement();
            ResultSet resultat;
            resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Assignement quiz = new Assignement();
                quiz.setID(resultat.getInt(1));
                quiz.setScore(resultat.getInt(2));
                quiz.setBadge(resultat.getInt(3));
                quiz.setUser(resultat.getInt(4));
                quiz.setQuiz(resultat.getInt(5));
               
                listquiz.add(quiz);
            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des quiz " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void metreajour(Assignement t) {
        String req = "UPDATE `assignement` SET `score`=?,`idbadge`=?,`iduser`=?,`idquiz`=? where id=?";
        try {
            prepared = cnx.prepareStatement(req);

            prepared.setInt(1, t.getScore());
            prepared.setInt(2, t.getBadge());
            prepared.setInt(3, t.getUser());
            prepared.setInt(4, t.getQuiz());
            prepared.setInt(5, t.getID());
          


            prepared.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimer(Assignement id) {
        String requete = "delete from assignement where id=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setInt(1, id.getID());
            prepared.executeUpdate();
            System.out.println("Assignement supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }

    }

    @Override
    public Assignement rechercheid(int id) {

        Assignement quiz = new Assignement();
        String requete = "select * from assignement where id=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setInt(1, id);

            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setScore(resultat.getInt(2));
                quiz.setBadge(resultat.getInt(3));
                quiz.setUser(resultat.getInt(4));
                quiz.setQuiz(resultat.getInt(5));

            }
            return quiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }

    }

    @Override
    public List<Assignement> recherchenom(String id) {
        List<Assignement> listquiz = new ArrayList<>();

        Assignement quiz = new Assignement();
        String requete = "select * from assignement where quiznom=?";
        try {
            prepared.setString(1, id);

            prepared = cnx.prepareStatement(requete);

            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setScore(resultat.getInt(2));
                quiz.setBadge(resultat.getInt(3));
                quiz.setUser(resultat.getInt(4));
                quiz.setQuiz(resultat.getInt(5));
                listquiz.add(quiz);

            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Assignement> recherchetype(String id) {
        Assignement quiz = new Assignement();
        List<Assignement> listquiz = new ArrayList<>();

        String requete = "select * from assignement where type=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setString(1, id);
            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setScore(resultat.getInt(2));
                quiz.setBadge(resultat.getInt(3));
                quiz.setUser(resultat.getInt(4));
                quiz.setQuiz(resultat.getInt(5));
                listquiz.add(quiz);

            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }
    }
    

}

