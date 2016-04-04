/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Quiz.ChoixUnique;

import static GUI.FXMLPasserQuizEntrainementController.exam;
import static GUI.FXMLPasserQuizEntrainementController.firas1;
import static GUI.FXMLPasserQuizEntrainementController.qinst;
import static GUI.FXMLPasserQuizEntrainementController.total;
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
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class FXMLChoixUnique4Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label nomquiz ;
    @FXML
    private RadioButton chk1;
    @FXML
    private RadioButton chk2;
    @FXML
    private RadioButton chk3;
    @FXML
    private RadioButton chk4;
    @FXML
    private RadioButton chk5;
    @FXML
    private GridPane gp;
    
    
    
    List<Reponse> listrep = new ArrayList<>();
    int scorerep=0;
    boolean test;
    final ToggleGroup group = new ToggleGroup();

    
    
    public void suivant(ActionEvent event) throws IOException
    {
        test=false;
        scorerep=0;
        listrep = qinst.getListreponse();
            if (group.getSelectedToggle() != null) {
            if (group.getSelectedToggle().getUserData().toString().equals("1"))
            {
                test=true;
            }
            }




        if (test==true){
            scorerep=qinst.getPoint();
        }
        total=total+scorerep;
        
        
        /// fin des condition de recuperation 
        
        if (exam.getListquestion().size()-1==firas1)
        {
           ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/FXMLResultat.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show(); 
        }
        else
        {
        firas1++;
        qinst = exam.getListquestion().get(firas1);
        listrep = qinst.getListreponse();
        if (qinst.getType().equals("Choix unique"))
        {
        if(listrep.size()==1)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLChoixUnique1.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==2)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLChoixUnique2.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==3)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLChoixUnique3.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==4)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLChoixUnique4.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLChoixUnique5.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        }
        
        else if (qinst.getType().equals("Choix multiple"))
        {
        if(listrep.size()==1)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixMultiple/FXMLChoixMultiple1.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==2)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixMultiple/FXMLChoixMultiple2.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==3)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixMultiple/FXMLChoixMultiple3.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==4)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixMultiple/FXMLChoixMultiple4.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixMultiple/FXMLChoixMultiple5.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        }
        
        else if (qinst.getType().equals("Reponse par texte"))
        {
        if(listrep.size()==1)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ReponseText/FXMLReponseText1.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==2)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ReponseText/FXMLReponseText2.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==3)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ReponseText/FXMLReponseText3.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==4)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ReponseText/FXMLReponseText4.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ReponseText/FXMLReponseText5.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        }
    }       
                
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        nomquiz.setText(qinst.getQuestiontext());
        listrep = qinst.getListreponse();

        
        chk1.setText(listrep.get(0).getReponsetext());
        chk1.setToggleGroup(group);
        chk1.setUserData(listrep.get(0).isReponsecorrectradio());
        chk2.setText(listrep.get(1).getReponsetext());
        chk2.setToggleGroup(group);
        chk2.setUserData(listrep.get(1).isReponsecorrectradio());
        chk3.setText(listrep.get(2).getReponsetext());
        chk3.setToggleGroup(group);
        chk3.setUserData(listrep.get(2).isReponsecorrectradio());
        chk4.setText(listrep.get(3).getReponsetext());
        chk4.setToggleGroup(group);
        chk4.setUserData(listrep.get(3).isReponsecorrectradio());

    }      
    
}
