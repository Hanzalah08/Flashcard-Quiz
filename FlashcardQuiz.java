package flashcardquiz;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FlashcardQuiz extends Application {

    ArrayList<Flashcard> flashcards = new ArrayList<>();
    int currentIndex = 0;


    Label title = new Label("Flashcard Quiz App");

      Label questionLabel = new Label("Question");

        TextArea answerArea = new TextArea();

    TextField questionField = new TextField();
            TextField answerField = new TextField();


    Button showBtn = new Button("Show Answer");
       Button previousBtn = new Button("Previous");
    Button nextBtn = new Button("Next");

    Button addBtn = new Button("Add");
    Button editBtn = new Button("Edit");
    Button updateBtn = new Button("Update");
    Button deleteBtn = new Button("Delete");


   
    public void start(Stage primaryStage) {


        flashcards.add(new Flashcard("Which is the most hated country in the world?", "Israel"));
        flashcards.add(new Flashcard("Most famous personality in the world?", "Prophet Muhammad ﷺ "));
        flashcards.add(new Flashcard("King of Cricket?", "Bobbzy the King"));


        displayFlashcard();


        title.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#2c3e50;"
        );

        questionLabel.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;"
        );


        answerArea.setEditable(false);
        answerArea.setPrefHeight(120);

        answerArea.setStyle(
                "-fx-font-size:16px;" +
                "-fx-background-radius:10;"
        );


        questionField.setPromptText("Enter Question");
        answerField.setPromptText("Enter Answer");


        questionField.setPrefWidth(350);
        answerField.setPrefWidth(350);


        styleButton(showBtn,"#27ae60");
        styleButton(previousBtn,"#3498db");
        styleButton(nextBtn,"#3498db");

        styleButton(addBtn,"#8e44ad");
        styleButton(editBtn,"#f39c12");
        styleButton(updateBtn,"#16a085");
        styleButton(deleteBtn,"#e74c3c");

        showBtn.setOnAction(e -> {

            Flashcard card = flashcards.get(currentIndex);

            answerArea.setText(card.getAnswer());

        });



        nextBtn.setOnAction(e -> {

            if(currentIndex < flashcards.size()-1){

              currentIndex++;

              displayFlashcard();

            }

        });


        previousBtn.setOnAction(e -> {


            if(currentIndex > 0){
                currentIndex--;

                displayFlashcard();

            }

        });


        addBtn.setOnAction(e -> {


            Flashcard card =
                    new Flashcard(
                            questionField.getText(),
                            answerField.getText()
                    );


            flashcards.add(card);


            currentIndex = flashcards.size()-1;


            displayFlashcard();


            questionField.clear();
            answerField.clear();


        });


        editBtn.setOnAction(e -> {


            Flashcard card =
                    flashcards.get(currentIndex);


            questionField.setText(card.getQuestion());

            answerField.setText(card.getAnswer());


        });




        updateBtn.setOnAction(e -> {


            Flashcard card =
                    flashcards.get(currentIndex);


            card.setQuestion(questionField.getText());

            card.setAnswer(answerField.getText());


            displayFlashcard();


        });

        deleteBtn.setOnAction(e -> {


            flashcards.remove(currentIndex);


            if(currentIndex >= flashcards.size()){

                currentIndex--;

            }


            displayFlashcard();


        });





        HBox navigation =
                new HBox(15,previousBtn,nextBtn);

        navigation.setAlignment(Pos.CENTER);



        HBox operations =
                new HBox(15,
                        addBtn,
                        editBtn,
                        updateBtn,
                        deleteBtn
                );


        operations.setAlignment(Pos.CENTER);



        VBox cardBox = new VBox(15);

        cardBox.setPadding(new Insets(25));

        cardBox.setAlignment(Pos.CENTER);


        cardBox.setStyle(

                "-fx-background-color:white;" +
                "-fx-background-radius:15;" +
                "-fx-effect: dropshadow(gaussian,gray,10,0,0,5);"

        );



        cardBox.getChildren().addAll(

                questionLabel,
                showBtn,
                answerArea,

                new Label("Question"),
                questionField,

                new Label("Answer"),
                answerField,

                navigation,
                operations

        );



        VBox root = new VBox(20);

        root.setPadding(new Insets(30));

        root.setAlignment(Pos.CENTER);


        root.setStyle(

                "-fx-background-color:linear-gradient(to bottom,#74ebd5,#ACB6E5);"

        );



        root.getChildren().addAll(
                title,
                cardBox
        );



        Scene scene =
                new Scene(root,600,700);



        primaryStage.setTitle("Flashcard Quiz");

        primaryStage.setScene(scene);

        primaryStage.show();

    }





    public void displayFlashcard(){


        if(flashcards.size()>0){

            Flashcard card =
                    flashcards.get(currentIndex);


            questionLabel.setText(
                    card.getQuestion()
            );


            answerArea.clear();

        }

    }





    public void styleButton(Button btn,String color){


        btn.setStyle(

                "-fx-background-color:"+color+";" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:10;"

        );


        btn.setPrefWidth(110);


    }





    public static void main(String[] args){

        launch(args);

    }

}