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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Firas
 */
public class QuizlistController implements Initializable {
    @FXML
    TableView table_formation;
    
    QuizDAO f = new QuizDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table_formation.getColumns().clear();
        TableColumn<Quiz, String> nomCol1 = new TableColumn("Titre");
        nomCol1.setCellValueFactory(
                new PropertyValueFactory<Quiz, String>("quiznom")
        );

        table_formation.getColumns().addAll(nomCol1);

        List<Quiz> list;
        ObservableList<Quiz> data;
        list = f.afficherquiz();
        data = FXCollections.observableArrayList(list);
        table_formation.setItems(data);

    }
}
