/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.DAO;

import com.mooc.Util.MyConnexion;
import com.mooc.entities.Quiz;
import com.mooc.IDAO.IQuizDAO;
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
public class QuizDAO implements IQuizDAO {

    private Connection cnx;
    private PreparedStatement prepared;

    public QuizDAO() {
        cnx = new MyConnexion().connection();
    }

    @Override
    public void ajouter(Quiz q) {
        String req = "insert into quiz (quiznom,quizdescription,dateajout,intro,type,time,idcour) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, q.getQuiznom());
            ps.setString(2, q.getQuizdescription());
            ps.setString(3,q.getDateajout());
            ps.setString(4, q.getIntro());
            ps.setString(5, q.getType());
            ps.setInt(6, q.getDuree());
            ps.setInt(7, q.getCour());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Quiz getquiz(int id) {
        Quiz quiz = new Quiz();
        String requete = "select * from quiz where id=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setInt(1, id);
            ResultSet resultat;
            resultat = prepared.executeQuery();

            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setQuiznom(resultat.getString(2));
                quiz.setQuizdescription(resultat.getString(3));
                quiz.setDateajout(resultat.getString(4));
                quiz.setIntro(resultat.getString(5));
                quiz.setType(resultat.getString(6));
                quiz.setDuree(resultat.getInt(7));
                quiz.setCour(resultat.getInt(8));
            }
            return quiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des quiz " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Quiz> afficherquiz() {
        List<Quiz> listquiz = new ArrayList<>();
        String requete = "select * from quiz";
        try {
            Statement ps;
            ps = cnx.createStatement();
            ResultSet resultat;
            resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Quiz quiz = new Quiz();
                quiz.setID(resultat.getInt(1));
                quiz.setQuiznom(resultat.getString(2));
                quiz.setQuizdescription(resultat.getString(3));
                quiz.setDateajout(resultat.getString(4));
                quiz.setIntro(resultat.getString(5));
                quiz.setType(resultat.getString(6));
                quiz.setDuree(resultat.getInt(7));
                quiz.setCour(resultat.getInt(8));
                listquiz.add(quiz);
            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des quiz " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void metreajour(Quiz t) {
        String req = "UPDATE `quiz` SET `quiznom`=?,`quizdescription`=?,`dateajout`=?,`intro`=?,`type`=?,`time`=?,`idcour`=? where id=?";
        try {
            prepared = cnx.prepareStatement(req);

            prepared.setString(1, t.getQuiznom());
            prepared.setString(2, t.getQuizdescription());
            prepared.setString(3, t.getDateajout());
            prepared.setString(4, t.getIntro());
            prepared.setString(5, t.getType());
            prepared.setDouble(6, t.getDuree());
            prepared.setDouble(7, t.getCour());

            prepared.setInt(8, t.getID());

            prepared.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimer(Quiz id) {
        String requete = "delete from quiz where id=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setInt(1, id.getID());
            prepared.executeUpdate();
            System.out.println("Quiz supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }

    }

    @Override
    public Quiz rechercheid(int id) {

        Quiz quiz = new Quiz();
        String requete = "select * from quiz where id=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setInt(1, id);

            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setQuiznom(resultat.getString(2));
                quiz.setQuizdescription(resultat.getString(3));
                quiz.setDateajout(resultat.getString(4));
                quiz.setIntro(resultat.getString(5));
                quiz.setType(resultat.getString(6));
                quiz.setDuree(resultat.getInt(7));
                quiz.setCour(resultat.getInt(8));

            }
            return quiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }

    }

    @Override
    public Quiz recherchenom(String id) {

        Quiz quiz = new Quiz();
        String requete = "select * from quiz where quiznom=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setString(1, id);


            ResultSet resultat = prepared.executeQuery();
                      while (resultat.next()) {

                quiz.setID(resultat.getInt(1));
                quiz.setQuiznom(resultat.getString(2));
                quiz.setQuizdescription(resultat.getString(3));
                quiz.setDateajout(resultat.getString(4));
                quiz.setIntro(resultat.getString(5));
                quiz.setType(resultat.getString(6));
                quiz.setDuree(resultat.getInt(7));
                quiz.setCour(resultat.getInt(8));

                      }
            return quiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Quiz> recherchetype(String id) {
        Quiz quiz = new Quiz();
        List<Quiz> listquiz = new ArrayList<>();

        String requete = "select * from quiz where type=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setString(1, id);
            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setQuiznom(resultat.getString(2));
                quiz.setQuizdescription(resultat.getString(3));
                quiz.setDateajout(resultat.getString(4));
                quiz.setIntro(resultat.getString(5));
                quiz.setType(resultat.getString(6));
                quiz.setDuree(resultat.getInt(7));
                quiz.setCour(resultat.getInt(8));
                listquiz.add(quiz);

            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }
    }

}
