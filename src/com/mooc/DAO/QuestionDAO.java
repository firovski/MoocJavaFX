/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.DAO;

import com.mooc.IDAO.IQuestionDAO;
import com.mooc.Util.MyConnexion;
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
public class QuestionDAO implements IQuestionDAO {


    private final Connection cnx;
    private PreparedStatement prepared;
    public ReponseDAO rd= new ReponseDAO();

    public QuestionDAO() {
        cnx = new MyConnexion().connection();
    }

    @Override
    public void ajouter(Question q,int id) {
        String req = "insert into question (questiontext,type,point,idquiz) values (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, q.getQuestiontext());
            ps.setString(2, q.getType());
            ps.setInt(3, q.getPoint());
            ps.setInt(4, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Question getQuestion(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> afficherQuestion() {
        List<Question> listquiz = new ArrayList<>();
        String requete = "select * from question where idquiz=23";
        try {
            Statement ps;
            ps = cnx.createStatement();
            ResultSet resultat;
            resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Question quiz = new Question();
                quiz.setID(resultat.getInt(1));
                quiz.setQuestiontext(resultat.getString(2));
                quiz.setType(resultat.getString(3));
                quiz.setPoint(resultat.getInt(4));
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
    public void metreajour(Question t) {
        String req = "UPDATE `question` SET `questiontext`=?,`type`=?,`point`=? where id=?";
        try {
            prepared = cnx.prepareStatement(req);

            prepared.setString(1, t.getQuestiontext());
            prepared.setString(2, t.getType());
            prepared.setInt(3, t.getPoint());
          


            prepared.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimer(Question id) {
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
    public Question rechercheid(int id) {

        Question quiz = new Question();
        String requete = "select * from question where id=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setInt(1, id);

            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setQuestiontext(resultat.getString(2));
                quiz.setType(resultat.getString(3));
                quiz.setPoint(resultat.getInt(4));
                quiz.setQuiz(resultat.getInt(5));

            }
            return quiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }

    }

    @Override
    public List<Question> recherchenom(String id) {
        List<Question> listquiz = new ArrayList<>();

        Question quiz = new Question();
        String requete = "select * from question where quiznom=?";
        try {
            prepared.setString(1, id);

            prepared = cnx.prepareStatement(requete);

            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setQuestiontext(resultat.getString(2));
                quiz.setType(resultat.getString(3));
                quiz.setPoint(resultat.getInt(4));
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
    public List<Question> recherchetype(String id) {
        Question quiz = new Question();
        List<Question> listquiz = new ArrayList<>();

        String requete = "select * from question where type=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setString(1, id);
            ResultSet resultat = prepared.executeQuery();
            while (resultat.next()) {
                quiz.setID(resultat.getInt(1));
                quiz.setQuestiontext(resultat.getString(2));
                quiz.setType(resultat.getString(3));
                quiz.setPoint(resultat.getInt(4));
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
    public List<Question> ListByQuiz(int id) {
        List<Question> listquiz = new ArrayList<>();
        String requete = "select * from question where idquiz=?";
        try {
            prepared = cnx.prepareStatement(requete);
            prepared.setString(1, Integer.toString(id));
            ResultSet resultat = prepared.executeQuery();

            while (resultat.next()) {
                Question quiz = new Question();
                quiz.setID(resultat.getInt(1));
                quiz.setQuestiontext(resultat.getString(2));
                quiz.setType(resultat.getString(3));
                quiz.setPoint(resultat.getInt(4));
                quiz.setQuiz(resultat.getInt(5));
                quiz.setListreponse(rd.ListByQuestion(resultat.getInt(1)));
                listquiz.add(quiz);
            }
            return listquiz;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des quiz " + ex.getMessage());
            return null;
        }
    }

}
