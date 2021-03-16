package ru.vsu.cs.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainFormJava {

    private ListOfWords listOfWords;

    MainFormJava(ListOfWords listOfWords) {
        this.listOfWords = listOfWords;
    }

    @FXML
    private Button buttonToStart;

    @FXML
    private Button buttonGetForward;

    @FXML
    private Label labelWord;

    @FXML
    private Button buttonAddWord;

    @FXML
    private TextField txtFieldYourWord;

    @FXML
    private Button buttonSwapEveryTwo;

    @FXML
    private Button buttonSaveAll;

    @FXML
    void initialize() {
        buttonSwapEveryTwo.setOnAction(actionEvent -> {
            listOfWords.swapEveryTwo();
            labelWord.setText("/Completed/");
        });

        buttonGetForward.setOnAction(actionEvent -> {
            String word = listOfWords.getWord();
            if(word == null)
                labelWord.setText("/There words ended/");
            else
            labelWord.setText(word);
        });

        buttonToStart.setOnAction(actionEvent -> {
            listOfWords.toStart();
            labelWord.setText(listOfWords.getWord());
        });

        buttonAddWord.setOnAction(actionEvent -> {
            String word = txtFieldYourWord.getText();
            if(word.length() != 0) {
                listOfWords.addWord(word);
                labelWord.setText(listOfWords.getWord());
            }
        });

        buttonSaveAll.setOnAction(actionEvent -> {
            try {
                listOfWords.saveAll();
                labelWord.setText("/Completed/");
            } catch (IOException e) {
                e.printStackTrace();
                labelWord.setText("/Can't write on this file/");
            }
        });
    }
}