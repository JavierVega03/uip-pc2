# @Proyecto final... hotel

# @----------------------------------

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ReservacionHotel extends Application {
  public static void main(String[] args) { Application.launch(args); }

  private Scene mainScene;
  private Scene optionsScene;
  private Stage stage;

  @Override public void start(Stage stage) {
    this.stage   = stage;
    mainScene    = createMainScene();
    optionsScene = createOptionsScene();

    stage.setScene(mainScene);
    stage.show();
  }

  private Scene createMainScene() {
    VBox layout = new VBox(10);
    layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
    layout.getChildren().setAll(
      LabelBuilder.create()
        .text("Sistema de Reservacion")
        .style("-fx-font-weight: bold;") 
        .build(),
      HBoxBuilder.create()
        .spacing(5)
        .children(
          new Label("Nombre:"),
          new TextField("ejm: Javier")
         )
        .build(),
      HBoxBuilder.create()
        .spacing(5)
        .children(
          new Label("Apellido:"),
          new TextField("ejm: Vega")
         )
        .build(),
      new Label("Lugar principal:"),
      ChoiceBoxBuilder.<String>create()
        .items(FXCollections.observableArrayList(
          "The Waldorf-Astoria", 
          "The Plaza", 
          "The Algonquin Hotel"
        ))
        .build(),
      ButtonBuilder.create()
        .text("Opciones de Reservacion  >>")
        .onAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent t) {
            stage.setScene(optionsScene);
          }
        })
        .build(),
      ButtonBuilder.create()
        .text("Reservar")
        .defaultButton(true)
        .onAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent t) {
            stage.hide();
          }
        })
        .build()
    );

    return new Scene(layout);
  }

  private Scene createOptionsScene() {
    VBox layout = new VBox(10);
    layout.setStyle("-fx-background-color: azure; -fx-padding: 10;");
    layout.getChildren().setAll(
      new CheckBox("Desayuno"),
      new Label("Periodico:"),
      ChoiceBoxBuilder.<String>create()
        .items(FXCollections.observableArrayList(
          "La critica", 
          "El aprendo", 
          "La prensa"
        ))
        .build(),
      ButtonBuilder.create()
        .text("Opciones de Confirmación")
        .defaultButton(true)
        .onAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent t) {
            stage.setScene(mainScene);
          }
        })
        .build()
    );

    return new Scene(layout);
  }
}
