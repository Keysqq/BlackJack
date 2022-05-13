package com.example.blackjack;
//Dev:Justin Fredericks
//Script: Black Jack
//Date:5/09/2022
//Class: 171
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


public class BlackJackGame extends Application {
    int HouseScore=0;
    int wins=0;
    int PlayerScore=0;
    String Status;


    @Override
    public void start(Stage stage) throws IOException {

        Image[] imgg = new Image[4];
        imgg[0]= (new Image("club.PNG"));
        imgg[1]= (new Image("diamond.PNG"));
        imgg[2]= (new Image("heart.PNG"));
        imgg[3]= (new Image("spade.PNG"));
                // create a pane to house all nodes in using a grid concept
        GridPane grid = new GridPane();
        //create another grid to hold game/score info (bottom right)
        GridPane scoreBox = new GridPane();
        //vbox used to house game button controls (bottom left)
        VBox vb = new VBox();
        VBox vb1 = new VBox();
        StackPane stackBottomLeft = new StackPane();
        //ArrayList created in order to hold the deck of 52 cards
        ArrayList<Card> deck = new ArrayList<Card>();

        //method used to create the deck of cards
        //CreateDeck(deck);

        //style the main grid with padding fields
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(8);

        Button play = new Button("Play");
        Button hit = new Button("Hit ");
        Button call = new Button("Call");
        Button shuffle = new Button("Shuffle");
    //shuffle.setPrefHeight(50);
        shuffle.setMaxHeight(1500);
        Label houseScore = new Label("House:");
        Label playerScore = new Label("Player:");
        Label status = new Label("Status:");
        Label runningWins = new Label("Wins:");

        Text hScore = new Text();
        Text pScore = new Text();
        Text stat = new Text();
        Text winCount = new Text();

        ImageView img1 = new ImageView("club.PNG");
        ImageView img2 = new ImageView("club.PNG");
        ImageView img3 = new ImageView("club.PNG");
        ImageView img4 = new ImageView("club.PNG");
        vb1.getChildren().addAll(shuffle);
        vb1.setAlignment(Pos.BASELINE_RIGHT);
        vb.getChildren().addAll(play,hit,call);

        vb.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);//clear out the firsts vbox overlay of the grid cell so to allow for the second vbox content be clickable
        StackPane.setAlignment(vb, Pos.TOP_LEFT);//hugs the firsts vb to left
        stackBottomLeft.getChildren().addAll(vb1,vb);


//region Card Visual set up
        //Creating a visual card
        Text txt1 = new Text();txt1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text txt2 = new Text();txt2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text txt3 = new Text();txt3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text txt4 = new Text();txt4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text txt5 = new Text();txt5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text txt6 = new Text();txt6.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text txt7 = new Text();txt7.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text txt8 = new Text();txt8.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Rectangle rec1 = new Rectangle(150,200);
        rec1.setStroke(Color.BLACK);
        rec1.setFill(Color.TRANSPARENT);
        rec1.setArcHeight(10.0d);
        rec1.setArcWidth(10.0d);

        Rectangle rec2 = new Rectangle(150,200);
        rec2.setStroke(Color.BLACK);
        rec2.setFill(Color.TRANSPARENT);
        rec2.setArcHeight(10.0d);
        rec2.setArcWidth(10.0d);

        Rectangle rec3 = new Rectangle(150,200);
        rec3.setStroke(Color.BLACK);
        rec3.setFill(Color.TRANSPARENT);
        rec3.setArcHeight(10.0d);
        rec3.setArcWidth(10.0d);

        Rectangle rec4 = new Rectangle(150,200);
        rec4.setStroke(Color.BLACK);
        rec4.setFill(Color.TRANSPARENT);
        rec4.setArcHeight(10.0d);
        rec4.setArcWidth(10.0d);

        //use of stack pane in order to stack text and images within a VBox on top of a shape.
        //cards consist of 2 vboxes to hold separate regions of the cards visual attributes
        StackPane stack1 = new StackPane();
        VBox card1 = new VBox(); VBox card11 = new VBox();
        card11.setPadding(new Insets(10,10,10,10));
        card1.getChildren().addAll(txt1);
        card11.getChildren().addAll(txt2);
        stack1.getChildren().addAll(rec1, card1,card11);
        card11.setAlignment( Pos.BOTTOM_RIGHT);

        StackPane stack2 = new StackPane();
        VBox card2 = new VBox(); VBox card22 = new VBox();
        card22.setPadding(new Insets(10,10,10,10));
        card2.getChildren().addAll(txt3,txt4);
        stack2.getChildren().addAll(rec2, card2,card22);
        card22.setAlignment( Pos.BOTTOM_RIGHT);

        StackPane stack3 = new StackPane();
        VBox card3 = new VBox();VBox card33 = new VBox();
        card33.setPadding(new Insets(10,10,10,10));
        card3.getChildren().addAll(txt5,txt6);
        stack3.getChildren().addAll(rec3, card3,card33);
        card33.setAlignment( Pos.BOTTOM_RIGHT);

        StackPane stack4 = new StackPane();
        VBox card4 = new VBox(); VBox card44 = new VBox();
        card44.setPadding(new Insets(10,10,10,10));
        card4.getChildren().addAll(txt7,txt8);
        stack4.getChildren().addAll(rec4, card4,card44);
        card44.setAlignment( Pos.BOTTOM_RIGHT);
//endregion
        //main housing grid
        //position nodes within spec col,row
        grid.setConstraints(stack1,0,0);
        grid.setConstraints(stack2,1,0);
        grid.setConstraints(stack3,0,1);
        grid.setConstraints(stack4,1,1);
        grid.setConstraints(stackBottomLeft,0,2);
        //grid.setConstraints(vb1,1,2);
        grid.setConstraints(scoreBox,1,2);

        //sub node grid (bottom right)
        scoreBox.setConstraints(houseScore,0,0);
        scoreBox.setConstraints(hScore,1,0);
        scoreBox.setConstraints(playerScore,0,1);
        scoreBox.setConstraints(pScore,1,1);
        scoreBox.setConstraints(status,0,2);
        scoreBox.setConstraints(stat,1,2);
        scoreBox.setConstraints(runningWins,0,3);
        scoreBox.setConstraints(winCount,1,3);

        //add the nodes to the pain
        scoreBox.getChildren().addAll(houseScore,playerScore,status,runningWins,hScore,pScore,stat,winCount);
        grid.getChildren().addAll(stack1,stack2,stack3,stack4,stackBottomLeft,scoreBox);

        call.setDisable(true);
        hit.setDisable(true);
        shuffle.setDisable(true);

//region play func
        //this method takes care of the play button
        //each time play is selected the deck is reset/ shuffled
        //once clicked four cards will be randomly delt to the player and house
        //cards that have been delt will be removed from deck
        //
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int cardIndex;
                int deckCount = 52;
                HouseScore=0;
                PlayerScore=0;
                call.setDisable(false);
                hit.setDisable(false);
                shuffle.setDisable(false);
                stat.setText("");
                deck.clear();//clear list for new deck shuffle
                CreateDeck(deck);

                //method call taking care of the initial hands, this will be called four times within the action event
                cardIndex = Play(deck, deckCount);

                deckCount -= 1;//deck count lowered bc card has been removed/drawn
                HouseScore+=deck.get(cardIndex).getNumber();//add to the hands total score
                txt1.setText(deck.get(cardIndex).getPip());//set txt to the cards value (upper left)
                img1.setImage(imgg[deck.get(cardIndex).getSuit()]);//set the cards suit image (bottom right)
                card11.getChildren().remove(img1);//remove so to clear for other games/image instances
                card11.getChildren().addAll(img1);//add the image
                //remove list item(card) so not to use again as its been delt
                deck.remove(cardIndex);

                cardIndex = Play(deck, deckCount);
                deckCount -= 1;
                HouseScore+=deck.get(cardIndex).getNumber();
                txt3.setText(deck.get(cardIndex).getPip());
                //txt4.setText(deck.get(cardIndex).getSuit());
                img2.setImage(imgg[deck.get(cardIndex).getSuit()]);
                card22.getChildren().remove(img2);
                card22.getChildren().addAll(img2);
                deck.remove(cardIndex);

                cardIndex = Play(deck, deckCount);
                deckCount -= 1;
                PlayerScore+=deck.get(cardIndex).getNumber();
                txt5.setText(deck.get(cardIndex).getPip());
                img3.setImage(imgg[deck.get(cardIndex).getSuit()]);
                card33.getChildren().remove(img3);
                card33.getChildren().addAll(img3);
                deck.remove(cardIndex);

                cardIndex = Play(deck, deckCount);
                deckCount -= 1;
                PlayerScore+=deck.get(cardIndex).getNumber();
                txt7.setText(deck.get(cardIndex).getPip());
                img3.setImage(imgg[deck.get(cardIndex).getSuit()]);
                card44.getChildren().remove(img4);
                card44.getChildren().addAll(img4);
                deck.remove(cardIndex);

                play.setDisable(true);//disable button after use

                //set/display scores (bottom right)
                hScore.setText(String.valueOf(HouseScore));
                pScore.setText(String.valueOf(PlayerScore));

            }
        });
        //endregion
//region hit func


        hit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int deckCount = 0;
                deckCount = deck.size();
                int cardIndex;
                //method call in order to draw another card
                cardIndex = Play(deck, deckCount);
                deckCount -= 1;
                PlayerScore+=deck.get(cardIndex).getNumber();
                txt5.setText(deck.get(cardIndex).getPip());
                img3.setImage(imgg[deck.get(cardIndex).getSuit()]);
                card33.getChildren().remove(img3);
                card33.getChildren().addAll(img3);
                deck.remove(cardIndex);
                pScore.setText(String.valueOf(PlayerScore));


                //check for a bust
                //end game and set buttons to proper stage of the game
                if(PlayerScore > 21){
                    stat.setText("Bust!!");
                    GameOver();
                    play.setDisable(false);//re enable button after use
                    call.setDisable(true);
                    hit.setDisable(true);
                }
            }
        });
        //endregion
//region call func
        //call checks for a win / tie
        //player and house scores are compared
        //buttons are set to appropriate usable status
        call.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(PlayerScore > HouseScore){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Game Info");
                    alert.setHeaderText("You have Won" );
                    alert.setContentText("Win");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });

                    //keep track of wins
                    //add to win total and display it
                    wins+=1;
                    winCount.setText(String.valueOf(wins));
                    stat.setText("Win");
                }//if block
                else if(HouseScore > PlayerScore){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Game Info");
                    alert.setHeaderText("You have Lost" );
                    alert.setContentText("House wins");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }

                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Game Info");
                    alert.setHeaderText("Its a tie" );
                    alert.setContentText("Tie");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }

                deck.clear();//clear list for new deck shuffle
                CreateDeck(deck);
                call.setDisable(true);
                hit.setDisable(true);
                play.setDisable(false);//re enable button after use

            }
        });
//endregion
// region shuffle func
        //Method to shuffle c
        shuffle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.shuffle(deck);
                stat.setText("Deck Shuffled");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Info");
                alert.setHeaderText("Deck Shuffled" );
                alert.setContentText("Deck Shuffled");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });

            }
        });
        //endregion

        Scene scene = new Scene(grid);
        stage.setTitle("Black Jack");
        stage.setScene(scene);
        stage.show();
    }//

    public static void main(String[] args) {
        launch();
    }//
//region Create Deck func
    public static void CreateDeck(ArrayList deck){
        //Create a 52 card deck
        String[] faceCards = {"King","Queen","Jack"};
        int[] suits = {0,1,2,3};
        //String[] suits = {"Spades","Hearts","Diamonds","Clubs"};

        //set pip cards
        for (int j =0;j<4;j++) {
            for (int i = 2; i < 11; i++) {
                deck.add(new Card(String.valueOf(i),suits[j], i));
            }
        }
        //set face cards
        for(int j=0;j<4;j++){
            for (int i =0;i<faceCards.length;i++){

                deck.add(new Card(faceCards[i],suits[j],10));
                //deck.add(new Card(faceCards[i],10));
            }
        }
        //set Aces
        for (int i = 0;i<4;i++){
            deck.add(new Card("Ace",suits[i],11));
        }
    }//

    public static int Play(ArrayList deck,int deckCount){
        int temp;
        Random rand = new Random();
        temp = rand.nextInt(deckCount);
        return temp;
    }//

    public static void GameOver(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Info");
        alert.setHeaderText("You have lost" );
        alert.setContentText("You went over!");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });

    }
    //endregion


}//