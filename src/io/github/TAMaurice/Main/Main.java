package io.github.TAMaurice.Main;

import javafx.stage.*;

import javax.security.auth.login.LoginException;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle(Variables.BotName + " GUI");

		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		

		final TextField subtitleText0 = new TextField();
		subtitleText0.setPromptText("Title of Story 1:");
		subtitleText0.setPrefColumnCount(10);
		subtitleText0.getText();
		GridPane.setConstraints(subtitleText0, 0, 0);
		grid.getChildren().add(subtitleText0);
		

		final TextField textText0 = new TextField();
		textText0.setPromptText("Text of Story 1:");
		textText0.setMinSize(100, 50);
		GridPane.setConstraints(textText0, 0, 1);
		grid.getChildren().add(textText0);
		
		//////////////////////////////////////////////
		
		final TextField subtitleText1 = new TextField();
		subtitleText1.setPrefColumnCount(15);
		subtitleText1.setPromptText("Title of Story 2:");
		GridPane.setConstraints(subtitleText1, 0, 2);
		grid.getChildren().add(subtitleText1);
		
		final TextField textText1 = new TextField();
		textText1.setPrefColumnCount(15);
		textText1.setPromptText("Title of Story 2:");
		textText1.setMinSize(100, 50);
		GridPane.setConstraints(textText1, 0, 3);
		grid.getChildren().add(textText1);
		
		//////////////////////////////////////////////
		
		final TextField subtitleText2 = new TextField();
		subtitleText2.setPrefColumnCount(15);
		subtitleText2.setPromptText("Title of Story 2:");
		GridPane.setConstraints(subtitleText2, 0, 4);
		grid.getChildren().add(subtitleText2);
		
		final TextField textText2 = new TextField();
		textText2.setPrefColumnCount(15);
		textText2.setPromptText("Title of Story 2:");
		textText2.setMinSize(100, 50);
		GridPane.setConstraints(textText2, 0, 5);
		grid.getChildren().add(textText2);
		
		/////////////////////////////////////////////

		Button submit = new Button("Submit");
		GridPane.setConstraints(submit, 1, 0);
		grid.getChildren().add(submit);
		

		Button clear = new Button("Clear");
		GridPane.setConstraints(clear, 1, 1);
		grid.getChildren().add(clear);
		
		
		Pane root = new StackPane();
		root.getChildren().add(grid);
		primaryStage.setScene(new Scene(root, 400, 300));
		primaryStage.show();
		
		
		//Adding a Label
		final Label label = new Label();
		GridPane.setConstraints(label, 0, 3);
		GridPane.setColumnSpan(label, 2);
		grid.getChildren().add(label);

		//Setting an action for the Submit button
		submit.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		    public void handle(ActionEvent e) {
			MainBot.subtitle0 = subtitleText0.getText();
			MainBot.subtitle1 = subtitleText1.getText();
			MainBot.subtitle2 = subtitleText2.getText();
			
			MainBot.text0 = textText0.getText();
			MainBot.text1 = textText1.getText();
			MainBot.text2 = textText2.getText();
			
			try {
				MainBot.startBot();
			} catch (LoginException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		}
});
		 
		//Setting an action for the Clear button
		clear.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		    public void handle(ActionEvent e) {
			subtitleText0.clear();
			subtitleText1.clear();
			subtitleText2.clear();
			textText0.clear();
			textText1.clear();
			textText2.clear();
		        label.setText(null);
		    }
		});
	}

}
