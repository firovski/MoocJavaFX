/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.FXMLPasserQuizEntrainementController.exam;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static GUI.FXMLPasserQuizEntrainementController.firas1;
import static GUI.FXMLPasserQuizEntrainementController.qinst;
import static GUI.FirasController.rep;
import static GUI.QuizlistController.idquiz1;
import com.mooc.DAO.QuestionDAO;
import com.mooc.DAO.QuizDAO;
import com.mooc.entities.Reponse;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Firas
 */
public class Quiztest extends Application {
    
public static void main(String[] args) {
	Application.launch(Quiztest.class, args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        CheckBox c= new CheckBox();
        TextField txt= new TextField();
        VBox v = new VBox(20);
        HBox h1 = new HBox(95);
        HBox h2 = new HBox(55);
        HBox h3 = new HBox(30);
        HBox h4 = new HBox(40);
        Scene sc = new Scene(v,900,600);
        QuizDAO qd = new QuizDAO();
        QuestionDAO questd = new QuestionDAO();
        exam = qd.getquiz(23);
        exam.setListquestion(questd.ListByQuiz(23));
        qinst = exam.getListquestion().get(0);

        ////////////////************////////////////////
        TextField t1 = new TextField();
        t1.setText(qinst.getQuestiontext());
        List<Reponse> listrep = new ArrayList<>();
        listrep= qinst.getListreponse();
        
        
        if (qinst.getType().equals("Choix unique")){
        for (int i=0;i<listrep.size();i++)
        {  
            rep =listrep.get(i);

        }
            }
            else if (qinst.getType().equals("Choix multiple")) 
            {

                for (int i=0;i<listrep.size();i++)
        {  
            rep =listrep.get(i);
                   h1.getChildren().addAll(c);

        }
                
            }
            else
            {
            for (int i=0;i<listrep.size();i++)
        {  
            rep =listrep.get(i);
            v.getChildren().addAll(txt);
        }
            }
        Button but = new Button("enzel");
        but.setOnAction(e-> System.out.println("kkkk"));
        h3.getChildren().addAll(t1);
                    v.getChildren().addAll(h1,h2,h3,h4,but);

        
    
        
        
        
        
                ////////////////************////////////////////

        
        
        stage.setScene(sc);
        v.setAlignment(Pos.CENTER);
        v.setFillWidth(false);
        stage.show();
    }
    
}
