/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.mooc.DAO.QuizDAO;
import com.mooc.entities.Quiz;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Firas
 */
public class QuizAddController implements Initializable {
    ObservableList<String> typelist = FXCollections.observableArrayList("Final","Entrainement");

    @FXML
    private TextField quiznom;
    @FXML
    private TextField quizdescription;
    @FXML
    private DatePicker dateajout;
    @FXML
    private TextField intro;
    @FXML
    private ChoiceBox type ;
    @FXML
    private TextField duree;
    @FXML
    private TextField cour;
    @FXML
    private Button add;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */

    @FXML
    public void AjouterQuiz(ActionEvent event) throws IOException {
        Quiz quiz = new Quiz();
        QuizDAO qd = new QuizDAO();
        quiz.setQuiznom(quiznom.getText());
        quiz.setQuizdescription(quizdescription.getText());
        quiz.setDateajout(java.sql.Date.valueOf(dateajout.getValue()).toString());
        quiz.setIntro(intro.getText());
        quiz.setType(type.getSelectionModel().getSelectedItem().toString());
        quiz.setDuree(Integer.parseInt(duree.getText()));
        quiz.setCour(Integer.parseInt(cour.getText()));
        qd.ajouter(quiz);
        
        
    
    
        ((Node)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLQuizlist.fxml"));
        loader.load();
        Parent p =loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
        
    
    
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.setItems(typelist);

    }
}
