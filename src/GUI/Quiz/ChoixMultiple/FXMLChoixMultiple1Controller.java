/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Quiz.ChoixMultiple;

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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class FXMLChoixMultiple1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private Label nomquiz ;
    @FXML
    private CheckBox chk1;
    @FXML
    private CheckBox chk2;
    @FXML
    private CheckBox chk3;
    @FXML
    private CheckBox chk4;
    @FXML
    private CheckBox chk5;
    @FXML
    private GridPane gp;
    
    
    List<Reponse> listrep = new ArrayList<>();
    int scorerep=0;
    boolean test;
    
    
    public void suivant(ActionEvent event) throws IOException
    {
        test=false;
        scorerep=0;
        listrep = qinst.getListreponse();
        ///chk1
        if(chk1.isSelected())
        {
        if(listrep.get(0).isReponsecorrectradio())
        {
            test=true;
        }
        else
        {
            test=false;

        }
        }

        if (test==true){
            scorerep=qinst.getPoint();
        }
                total=total+scorerep;

        
        /// fin des condition de recuperation 
        
        firas1++;
        qinst = exam.getListquestion().get(firas1);
        listrep = qinst.getListreponse();
        if (qinst.getType().equals("Choix unique"))
        {
        if(listrep.size()==1)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixUnique/FXMLChoixUnique1.fxml"));
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
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixUnique/FXMLChoixUnique2.fxml"));
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
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixUnique/FXMLChoixUnique3.fxml"));
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
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixUnique/FXMLChoixUnique4.fxml"));
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
            loader.setLocation(getClass().getResource("/GUI/Quiz/ChoixUnique/FXMLChoixUnique5.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLChoixMultiple1.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLChoixMultiple2.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLChoixMultiple3.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLChoixMultiple4.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLChoixMultiple5.fxml"));
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        nomquiz.setText(qinst.getQuestiontext());
        listrep = qinst.getListreponse();

        
        chk1.setText(listrep.get(0).getReponsetext());
    
    }    
    
    
     
    
}
