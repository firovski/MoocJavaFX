/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import static GUI.FXMLPasserQuizEntrainementController.exam;
import static GUI.FXMLPasserQuizEntrainementController.firas1;
import static GUI.FXMLPasserQuizEntrainementController.qinst;
import static GUI.FirasController.rep;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author Firas
 */
public class TestFinalController implements Initializable  {
    TextField txt= new TextField();

    @FXML
    private Text t1;
    @FXML
    private Button btn;
    @FXML
    public GridPane gp;
    
    public TextField tx1;
    
    public TextField tx2;
    
    public TextField tx3;
    
    public TextField tx4;
    
    public TextField tx5;
    
    public CheckBox c1;
    
    public CheckBox c2;
    
    public CheckBox c3;
    
    public CheckBox c4;
    
    public CheckBox c5;

        public RadioButton r1;

        final ToggleGroup group = new ToggleGroup();

    
    
     @FXML
     private void TerminerAction(ActionEvent event) throws IOException {
        if (firas1 < ((exam.getListquestion().size()) - 2)) {
            
                firas1++;
                        qinst = exam.getListquestion().get(firas1);

            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TestFinal.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
            

        } else {
            firas1++;
            qinst = exam.getListquestion().get(firas1);

            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TestFinal.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
        }

 
       
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

        t1.setText(qinst.getQuestiontext());
        List<Reponse> listrep = new ArrayList<>();
        listrep= qinst.getListreponse();
        
        
        if (qinst.getType().equals("Choix unique")){
            RadioButton radio1 = new RadioButton();
            for (int i=0;i<listrep.size();i++)
        {  
            rep =listrep.get(i);
            Label l6 = new Label(rep.getReponsetext());
            radio1.setToggleGroup(group);
            radio1.setId("r1");
            gp.add(l6,0,i);
            gp.add(radio1,1,i);
        }
            
        
        }
        
        else if (qinst.getType().equals("Choix multiple")) 
        {
        /*switch (listrep.size()) {
            case 1:  
            {*/
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
               /*      break;
            }
            case 2: 
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
            rep =listrep.get(1);
            Label l2 = new Label(rep.getReponsetext());
            gp.add(l2,0,1);
            gp.add(c2, 1, 1);
                     break;
            }
            case 3: 
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
            rep =listrep.get(1);
            Label l2 = new Label(rep.getReponsetext());
            gp.add(l2,0,1);
            gp.add(c2, 1, 1);
            rep =listrep.get(2);
            Label l3 = new Label(rep.getReponsetext());
            gp.add(l3,0,2);
            gp.add(c3, 1, 2);
                     break;
            }
            case 4:  
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
            rep =listrep.get(1);
            Label l2 = new Label(rep.getReponsetext());
            gp.add(l2,0,1);
            gp.add(c2, 1, 1);
            rep =listrep.get(2);
            Label l3 = new Label(rep.getReponsetext());
            gp.add(l3,0,2);
            gp.add(c3, 1, 2);
            rep =listrep.get(3);
            Label l4 = new Label(rep.getReponsetext());
            gp.add(l4,0,3);
            gp.add(c4, 1, 3);
                     break;
            }
            default: 
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
            rep =listrep.get(1);
            Label l2 = new Label(rep.getReponsetext());
            gp.add(l2,0,1);
            gp.add(c2, 1, 1);
            rep =listrep.get(2);
            Label l3 = new Label(rep.getReponsetext());
            gp.add(l3,0,2);
            gp.add(c3, 1, 2);
            rep =listrep.get(3);
            Label l4 = new Label(rep.getReponsetext());
            gp.add(l4,0,3);
            gp.add(c4, 1, 3);
            rep =listrep.get(3);
            Label l5 = new Label(rep.getReponsetext());
            gp.add(l5,0,4);
            gp.add(c5, 1, 4);
                break;
            }
            }
            
                
        }
        else
        {
        switch (listrep.size()) {
            case 1:  
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
                     break;
            }
            case 2: 
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
            rep =listrep.get(1);
            Label l2 = new Label(rep.getReponsetext());
            gp.add(l2,0,1);
            gp.add(c2, 1, 1);
                     break;
            }
            case 3: 
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
            rep =listrep.get(1);
            Label l2 = new Label(rep.getReponsetext());
            gp.add(l2,0,1);
            gp.add(c2, 1, 1);
            rep =listrep.get(2);
            Label l3 = new Label(rep.getReponsetext());
            gp.add(l3,0,2);
            gp.add(c3, 1, 2);
                     break;
            }
            case 4:  
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(c1, 1, 0);
            rep =listrep.get(1);
            Label l2 = new Label(rep.getReponsetext());
            gp.add(l2,0,1);
            gp.add(c2, 1, 1);
            rep =listrep.get(2);
            Label l3 = new Label(rep.getReponsetext());
            gp.add(l3,0,2);
            gp.add(c3, 1, 2);
            rep =listrep.get(3);
            Label l4 = new Label(rep.getReponsetext());
            gp.add(l4,0,3);
            gp.add(c4, 1, 3);
                     break;
            }
            default: 
            {
            rep =listrep.get(0);
            Label l1 = new Label(rep.getReponsetext());
            gp.add(l1,0,0);
            gp.add(tx1, 1, 0);
            rep =listrep.get(1);
            Label l2 = new Label(rep.getReponsetext());
            gp.add(l2,0,1);
            gp.add(tx2, 1, 1);
            rep =listrep.get(2);
            Label l3 = new Label(rep.getReponsetext());
            gp.add(l3,0,2);
            gp.add(tx3, 1, 2);
            rep =listrep.get(3);
            Label l4 = new Label(rep.getReponsetext());
            gp.add(l4,0,3);
            gp.add(tx4, 1, 3);
            rep =listrep.get(3);
            Label l5 = new Label(rep.getReponsetext());
            gp.add(l5,0,4);
            gp.add(tx5, 1, 4);
                break;
            }
            }
            
           
        }*/
    }
    
}
}

