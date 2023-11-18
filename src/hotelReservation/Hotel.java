package hotelReservation;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Hotel extends Application {

    public List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        HBox hTop = new HBox(10);
        HBox hDown = new HBox(10);
        root.getChildren().addAll(hTop, hDown);


        VBox vLeft = new VBox(10);
        TextArea textArea = new TextArea("");
        textArea.setPrefHeight(500);
        textArea.setPrefWidth(500);

        hTop.getChildren().addAll(vLeft, textArea);

        Label lblName = new Label("Full name : ");
        TextField txtName = new TextField();
        Label lblStructure = new Label("Structure of the room : ");
        TextField txtStructure = new TextField();
        Label lblBuget = new Label("Budget : ");
        TextField txtBuget = new TextField();
        Label lblStart = new Label("Start date : ");
        TextField txtStart = new TextField();
        txtStart.setPromptText("dd/mm/yyyy");
        Label lblEnd = new Label("End date : ");
        TextField txtEnd = new TextField();
        txtEnd.setPromptText("dd/mm/yyyy");
        CheckBox chBoxPremium = new CheckBox("Premium guest ");
        vLeft.getChildren().addAll(lblName, txtName, lblStructure, txtStructure,
                lblBuget, txtBuget, lblStart, txtStart, lblEnd, txtEnd, chBoxPremium);

        Button btnLoad = new Button("Load room");
        Button btnFind = new Button("Find room");
        Button btnOverview = new Button("Overview occupied room");
        hDown.getChildren().addAll(btnLoad, btnFind, btnOverview);
        hDown.setAlignment(Pos.BOTTOM_RIGHT);

        btnLoad.setOnAction(e -> {
            btnLoad.setDisable(true);

            try {
                Path path = Paths.get("/home/nevena/IdeaProjects/Exercises/src/rooms.txt");
                List<String> lines = Files.readAllLines(path);
                for (String line : lines) {
                    String[] tmp = line.split(", ");
                    int number = Integer.parseInt(tmp[0].trim());
                    int structureRoom = Integer.parseInt(tmp[1].trim());
                    int price = Integer.parseInt(tmp[2].trim());

                    if (tmp.length == 3)
                        rooms.add(new StandardRoom(number, price, structureRoom));

                    else
                        rooms.add(new PremiumRoom(number, price, structureRoom));

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            textArea.setText("\nAll rooms in hotel : \n\n");

            for(Room r:rooms){
                textArea.appendText(r.toString());

            }

        });

        btnFind.setOnAction(e -> {

            try {
                String name = txtName.getText();
                int structure = Integer.parseInt(txtStructure.getText());
                int budget = Integer.parseInt(txtBuget.getText());

                Date dateStart = new Date(txtStart.getText());
                Date dateEnd = new Date(txtEnd.getText());

                Guest guest = new Guest(name, budget, chBoxPremium.isSelected());
                Period period = new Period(dateStart, dateEnd);

                for (Room r : rooms) {
                    if (r.getStructureRoom() >= structure && r.putGuest(period, guest)) {
                        textArea.setText("Guest : " + guest + "\n" + "stay in a room : "
                                + r.getNumber() + "\nperiod : " + period);
                        return;
                    }
                }
                textArea.setText("No rooms available !");


            } catch (IllegalArgumentException ex) {
                textArea.setText("Input error !");
            }
        });

        btnOverview.setOnAction(e->{

            textArea.setText("");

            for(Room r:rooms){
                textArea.appendText(r.toString());

            }

        });

        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Hotel Reservation");
        stage.show();
    }
}
