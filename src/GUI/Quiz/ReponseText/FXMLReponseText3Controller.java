/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Quiz.ReponseText;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class FXMLReponseText3Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
        

    @FXML
    private Label nomquiz ;
    @FXML
    private Label l1 ;
    @FXML
    private Label l2 ;
    @FXML
    private Label l3 ;
    @FXML
    private Label l4 ;
    @FXML
    private Label l5 ;
    @FXML
    private TextField chk1;
    @FXML
    private TextField chk2;
    @FXML
    private TextField chk3;
    @FXML
    private TextField chk4;
    @FXML
    private TextField chk5;
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
        
        if(chk1.getText().equals(listrep.get(0).getReponsecorrecttext()))
        {
            test=true;
        }
        else
        {
            test=false;

        }
        
        ///chk2
       
        if(chk2.getText().equals(listrep.get(1).getReponsecorrecttext()))
        {
            test=true;

        }
        else
        {
            test=false;

        }
        
        //chk3
       
        if(chk3.getText().equals(listrep.get(2).getReponsecorrecttext()))
        {
            test=true;
        }
        else
        {
        test=false;

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
            loader.setLocation(getClass().getResource("FXMLReponseText1.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLReponseText2.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLReponseText3.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLReponseText4.fxml"));
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
            loader.setLocation(getClass().getResource("FXMLReponseText5.fxml"));
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
        
        
        l1.setText(listrep.get(0).getReponsetext());
        l2.setText(listrep.get(1).getReponsetext());
        l3.setText(listrep.get(2).getReponsetext());
        
        
    }      
    
}
