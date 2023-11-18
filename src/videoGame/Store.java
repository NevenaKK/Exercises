package videoGame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Store extends Application {

    private final List<VideoGame> gameList=new ArrayList<>();

    private VBox root,vBox,vBox1,vBox2;
    private Button btnLoad,btnDisplay,btnSort,btnAdd;
    private HBox hBox,hBox1;
    private TextArea textArea;
    private TextField txtGenre,txtName,txtPrice,txtRequirement;
    private Label lbPlatform,lbSort,lbGenre,lbPrice,lbName,lbRequirement;
    private ToggleGroup toggleGroup,toggleGroup1,toggleGroup2;
    private RadioButton rbPC,rbPS4, rbXBOX,rbALL,rbName,rbPrice,rbXBOXadd,rbPCadd,rbPS4add;

    private void createGui (Stage stage){
        root=new VBox(10);
        root.setPadding(new Insets(10,15,10,15));


        btnLoad=new Button("Load video games");
        hBox=new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btnLoad);
        root.getChildren().addAll(hBox);

        textArea=new TextArea();
        root.getChildren().addAll(textArea);

        hBox1 =new HBox(70);
        vBox=new VBox(10);
        vBox1=new VBox(10);
        vBox2=new VBox(10);

        hBox1.getChildren().addAll(vBox,vBox1,vBox2);
        root.getChildren().addAll(hBox1);

        lbPlatform=new Label("Platform");
        toggleGroup=new ToggleGroup();
        rbPC=new RadioButton("PC");
        rbPS4=new RadioButton("PS4");
        rbXBOX=new RadioButton("XBOX ONE");
        rbALL=new RadioButton("All");
        rbPC.setToggleGroup(toggleGroup);
        rbPS4.setToggleGroup(toggleGroup);
        rbXBOX.setToggleGroup(toggleGroup);
        rbALL.setToggleGroup(toggleGroup);
        btnDisplay=new Button("Display");
        vBox.getChildren().addAll(lbPlatform,rbPC,rbPS4,rbXBOX,rbALL,btnDisplay);

        lbSort=new Label("Sort by : ");
        toggleGroup1=new ToggleGroup();
        rbName=new RadioButton("Name");
        rbPrice=new RadioButton("Price");
        rbName.setToggleGroup(toggleGroup1);
        rbPrice.setToggleGroup(toggleGroup1);
        btnSort=new Button("Sort");
        vBox1.getChildren().addAll(lbSort,rbName,rbPrice,btnSort);

        lbName=new Label("Name : ");
        txtName=new TextField();
        lbPrice=new Label("Price : ");
        txtPrice=new TextField();
        lbGenre=new Label("Genre : ");
        txtGenre=new TextField();
        lbRequirement=new Label("Requirement : ");
        txtRequirement=new TextField();
        toggleGroup2=new ToggleGroup();
        rbPCadd=new RadioButton("PC");
        rbPS4add=new RadioButton("PS4");
        rbXBOXadd=new RadioButton("XBOX ONE");
        rbPCadd.setToggleGroup(toggleGroup2);
        rbPS4add.setToggleGroup(toggleGroup2);
        rbXBOXadd.setToggleGroup(toggleGroup2);
        btnAdd=new Button("Add");
        vBox2.getChildren().addAll(lbName,txtName,lbPrice,txtPrice,
                lbGenre,txtGenre,lbRequirement,txtRequirement,rbPCadd,rbPS4add,
                rbXBOXadd,btnAdd);
    }
    @Override
    public void start(Stage stage) throws Exception {

        createGui(stage);

        btnLoad.setOnAction(e ->
        {
            Path input = Paths.get("/home/nevena/IdeaProjects/Exercises/src/games.txt");

            try {
                List<String> lines = Files.readAllLines(input, StandardCharsets.UTF_8);
                for(String line : lines){
                    String[] tmp =line.split(",");

                    String platform=tmp[0].trim();
                    String name=tmp[1].trim();
                    String gener=tmp[2].trim();

                    int price=Integer.parseInt(tmp[3].trim());
                    String pl=platform.toLowerCase();
                    if(pl.equals("pc")){
                        int requirement =Integer.parseInt(tmp[4].trim());
                        gameList.add(new PCVideoGame(name,gener,price,requirement));
                    }else
                        gameList.add(new ConsoleVideoGame(name,gener,price,platform));

                }

                textArea.setText("Number of loaded games is : "+gameList.size());
            } catch (IOException ex) {
                textArea.setText("Faild to load games ! ");
            }


        });


        btnDisplay.setOnAction(e->{

            textArea.clear();

            for(VideoGame vg :gameList){
                boolean show=false;

                if(rbPC.isSelected() && vg.getPlatform().equals("pc"))
                    show=true;
                if(rbPS4.isSelected() && vg.getPlatform().equals("ps4"))
                    show=true;
                if (rbXBOX.isSelected() && vg.getPlatform().equals("xbone"))
                    show = true;
                if (rbALL.isSelected())
                    show = true;
                if (!rbPC.isSelected() && !rbPS4.isSelected() && !rbXBOX.isSelected() && !rbALL.isSelected())
                    show = true;

                if(show)
                    textArea.appendText(vg.toString()+"\n\n");
            }

        });

        btnSort.setOnAction(e->{

            if(rbName.isSelected()){
                gameList.sort(new Comparator<VideoGame>() {
                    @Override
                    public int compare(VideoGame a, VideoGame b) {
                        return a.getName().compareTo(b.getName());
                    }
                });
            }else if(rbPrice.isSelected()){
                gameList.sort(new Comparator<VideoGame>() {
                    @Override
                    public int compare(VideoGame a, VideoGame b) {
                        return Integer.compare(a.getPrice(), b.getPrice());
                    }
                });
            }

            btnDisplay.fire();

        });

        btnAdd.setOnAction(e->{

            try {
                String name=txtName.getText().trim();
                String genre=txtGenre.getText().trim();
                int price= Integer.parseInt(txtPrice.getText().trim());

                if(name.isEmpty() || genre.isEmpty()){
                    textArea.setText("Input error !");
                }
                if(rbPCadd.isSelected()){
                    int requirement =Integer.parseInt(txtRequirement.getText().trim());
                    gameList.add(new PCVideoGame(name,genre,price,requirement));
                }else if(rbPS4add.isSelected())
                    gameList.add(new ConsoleVideoGame(name,genre,price,"ps4"));
                else if(rbXBOXadd.isSelected())
                    gameList.add(new ConsoleVideoGame(name,genre,price,"xbone"));
                else
                    gameList.add(new ConsoleVideoGame(name,genre,price,"newGame"));

                textArea.setText("Game successfully added !");
            }catch (NumberFormatException e1) {
                textArea.setText("Input error !");
            }

        });



        stage.setTitle("Video Games");
        stage.setScene(new Scene(root,600,700));
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}
