/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.GUI;

import com.mooc.DAO.QuizDAO;
import com.mooc.entities.Quiz;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Firas
 */
public class FXMLQuizAjouterController implements Initializable {
    @FXML
    private TextField quiznom;
    @FXML
    private TextField quizdescription;
    @FXML
    private DatePicker dateajout;
    @FXML
    private TextField intro;
    @FXML
    private TextField type;
    @FXML
    private TextField duree;
    @FXML
    private TextField cour;
    @FXML
    private Button add;
    
    @FXML
    public void AjouterQuiz(ActionEvent event){
        Quiz quiz = new Quiz();
        QuizDAO qd = new QuizDAO();
        quiz.setQuiznom(quiznom.getText());
        quiz.setQuizdescription(quizdescription.getText());
        quiz.setDateajout(java.sql.Date.valueOf(dateajout.getValue()).toString());
        quiz.setIntro(intro.getText());
        quiz.setType(type.getText());
        quiz.setDuree(Integer.parseInt(duree.getText()));
        quiz.setCour(Integer.parseInt(cour.getText()));
        qd.ajouter(quiz);


    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
