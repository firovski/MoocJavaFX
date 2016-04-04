/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.mooc.DAO.QuizDAO;
import com.mooc.entities.Quiz;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Firas
 */
public class QuizlistController implements Initializable {
        public static int idquiz1;


    @FXML
    private ListView<String> listview;
    @FXML
    private TextField l1;
    @FXML
    private TextField l2;
    @FXML
    private TextField l3;
    @FXML
    private TextField l4;
    @FXML
    private TextField l5;
    @FXML
    private TextField l6;
    @FXML
    private Label message;
    
/**
 * Initializes the controller class.
 * @param url
 * @param rb
 */
    QuizDAO qd =new QuizDAO();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> listquiz = FXCollections.observableArrayList();
        List <Quiz> quiz = new ArrayList<Quiz>();
        quiz = qd.afficherquiz();
        for(Quiz q : quiz)
        {
        listquiz.add(q.getQuiznom());
        listview.setItems(listquiz);
        message.setText("");
        }

        
    }

    @FXML 
    public void handleMouseClick(ActionEvent event) {
    String x=listview.getSelectionModel().getSelectedItem();    
        Quiz q =qd.recherchenom(x);

    if (q!=null){
    l1.setText(q.getQuiznom());
    l2.setText(q.getQuizdescription());
    l3.setText(q.getIntro());
    l4.setText(q.getDateajout());
    l5.setText(q.getType());
    l6.setText(Integer.toString(q.getDuree()));
        message.setText("");

    }
    else 
    {
    l1.setText("");
    l2.setText("");
    l3.setText("");
    l4.setText("");
    l5.setText("");
    message.setText("");
    }
      
 }
     @FXML
     private void DeleteAction(ActionEvent event) throws IOException {
         String x=listview.getSelectionModel().getSelectedItem();    
        Quiz q =qd.recherchenom(x);
        qd.supprimer(q);
        
            message.setText("Quiz Supprimer avec succes");
 
     }
     
     @FXML
     private void passerAction(ActionEvent event) throws IOException {
         String x=listview.getSelectionModel().getSelectedItem();    
        Quiz q =qd.recherchenom(x);
         idquiz1=q.getID();
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLPasserQuizEntrainement.fxml"));
        loader.load();
        Parent p =loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     }
     
     @FXML
     private void UpdateAction(ActionEvent event) throws IOException {
        String x=listview.getSelectionModel().getSelectedItem();    
        Quiz q =qd.recherchenom(x);
        Quiz quiz = new Quiz();
        quiz.setID(q.getID());
        quiz.setQuiznom(l1.getText());
        quiz.setQuizdescription(l2.getText());
        quiz.setDateajout(l4.getText());
        quiz.setIntro(l3.getText());
        quiz.setType(l5.getText());
        quiz.setDuree(Integer.parseInt(l6.getText()));
        quiz.setCour(q.getCour());
        qd.metreajour(quiz);
                    message.setText("Quiz Modifier avec succes");

     }
     @FXML
    private void AddAction(ActionEvent event) throws IOException
    { 
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLQuizAjouter.fxml"));
        loader.load();
        Parent p =loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
        
    
    }

    
}

