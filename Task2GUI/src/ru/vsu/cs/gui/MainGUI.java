package ru.vsu.cs.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.vsu.cs.common.InputArgs;
import ru.vsu.cs.common.LinkList;
import ru.vsu.cs.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.Parameters params = getParameters();
        List<String> unnamedParams = getParameters().getUnnamed();
        String[] argsOfCommandLine = new String[unnamedParams.size()];
        unnamedParams.toArray(argsOfCommandLine);
        ListOfWords listOfWordsModel = run(parseArgs(argsOfCommandLine));
        MainFormJava mainFormJava = new MainFormJava(listOfWordsModel);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainForm.fxml"));
        loader.setController(mainFormJava);
        Parent root = loader.load();
        primaryStage.setTitle("List of Word");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static InputArgs parseArgs(String[] args) {
        InputArgs inputArgs = new InputArgs();
        if (args.length > 0) {
            if (args[0].equals("help")) {
                inputArgs.help = true;
                return inputArgs;
            } else {
                inputArgs.inputFile = args[0];
                inputArgs.outputFile = args[1];
            }
        } else {
            inputArgs.help = true;
            inputArgs.error = true;
        }
        return inputArgs;
    }

    public static ListOfWords run(InputArgs inputArgs) throws IOException {
        if (inputArgs.help) {
            if (inputArgs.error) {
                System.err.println("Error! Enter <input file> <output file> or \"help\"");
            } else {
                System.out.println("Usage:");
                System.out.println("the program works with text files. It splits the text of a file into words" +
                        "and demonstrates how a word list works based on a one-way linked list");
                System.out.println(" enter <input file> <output file>");
                System.out.println("enter \"help\" for reference");
            }
            return null;
        }
        LinkList linkList = FileUtils.readFromFile(inputArgs.inputFile);
        LinkList testList = new LinkList();
        FileUtils.writeToFile(testList, inputArgs.outputFile);
        if (linkList == null) {
            System.out.printf("Can't read file from %s", inputArgs.inputFile);
        } else {
            ListOfWords listOfWords = new ListOfWords(linkList, inputArgs.outputFile);
            return listOfWords;
        }

        return null;
    }
}

