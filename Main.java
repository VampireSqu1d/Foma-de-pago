package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import static javafx.scene.text.Font.font;


public class Main extends Application {

    private static GridPane TarjetaPanel, efectivoPane, todoLoDemas;
    private  static RadioButton tarjeta, efectivo, visa, MasterCard;
    private  static TextField recibido, APagar, bido, bio, codigo,
            numero, nombre, calle, numeroCalle, colonia, ciudad, estado;

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Forma de pago");
        Font fuente= font("Tahoma", FontWeight.NORMAL, 18);

        GridPane root = new GridPane();
        GridPane pago = new GridPane();
        pago.setHgap(5.0);
        pago.setVgap(3.0);

        Label forma = new Label("Forma De Pago:");
        forma.setFont(font("Tahoma", FontWeight.NORMAL, 20));

        pago.add(forma,0,0);
        RadioButton tarjeta = new RadioButton("tarjeta");
        tarjeta.setFont(font("Tahoma", FontWeight.NORMAL, 18));
        tarjeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tarjeta.isSelected()) {
                    efectivo.setDisable(true);
                    TarjetaPanel.setDisable(false);
                    TarjetaPanel.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                            "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: green;");
                } else{
                    visa.setSelected(false);
                    MasterCard.setSelected(false);
                    efectivo.setDisable(false);
                    TarjetaPanel.setDisable(true);
                    TarjetaPanel.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                            "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");
                    todoLoDemas.setDisable(true);
                    todoLoDemas.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                            "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");
                }
            }
        });
        pago.add(tarjeta,0,1);

        efectivo = new RadioButton("Efectivo");
        efectivo.setFont(font("Tahoma", FontWeight.NORMAL, 18));
        efectivo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (efectivo.isSelected()) {
                    tarjeta.setDisable(true);
                    efectivoPane.setDisable(false);
                    efectivoPane.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                            "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
                } else{
                    bio.setText("");
                    APagar.setText("");
                    bido.setText("");
                    tarjeta.setDisable(false);
                    efectivoPane.setDisable(true);
                    efectivoPane.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                            "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");
                    todoLoDemas.setDisable(true);
                    todoLoDemas.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                            "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");
                }
            }
        });
        pago.add(efectivo,0,2);

        pago.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: red;");

         TarjetaPanel = new GridPane();
         TarjetaPanel.setHgap(5);
         TarjetaPanel.setVgap(5);
         Label TarjetaL = new Label("Tarjeta:");
         TarjetaL.setFont(fuente);
         TarjetaPanel.add(TarjetaL, 0,0);

         visa = new RadioButton("Visa");
         visa.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 if (visa.isSelected()){
                     MasterCard.setDisable(true);
                     todoLoDemas.setDisable(false);
                     todoLoDemas.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                             "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: pink;");
                 }
                 else{
                     todoLoDemas.setDisable(true);
                     MasterCard.setDisable(false);
                     todoLoDemas.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                             "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");
                 }
             }
         });
         visa.setFont(fuente);
         TarjetaPanel.add(visa,0,1);

         MasterCard = new RadioButton("Master Card");
         MasterCard.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 if (MasterCard.isSelected()){
                     todoLoDemas.setDisable(false);
                     visa.setDisable(true);
                     todoLoDemas.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                             "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: pink;");
                 }
                 else{
                     visa.setDisable(false);
                     todoLoDemas.setDisable(true);
                     todoLoDemas.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                             "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");
                 }
             }
         });
         MasterCard.setFont(fuente);
         TarjetaPanel.add(MasterCard,0,2);

         Label importe = new Label("Importe a Pagar:");
         importe.setFont(fuente);
         TarjetaPanel.add(importe,1,0);

        recibido = new TextField();
        recibido.setFont(fuente);
        TarjetaPanel.add(recibido,1,1);
        TarjetaPanel.setVgap(5);

        TarjetaPanel.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");

        // Tercer panel(Panel de pago en efectivo)
        efectivoPane = new GridPane();

        APagar = new TextField();
        APagar.setFont(fuente);
        efectivoPane.add(APagar, 0,1);

        Label ImpAPagar = new Label("Importe A Pagar:");
        ImpAPagar.setFont(fuente);
        efectivoPane.add(ImpAPagar, 0,0);

        Label reci = new Label("Recibido:");
        reci.setFont(fuente);
        efectivoPane.add(reci,0,2);

        bido = new TextField();
        bido.setFont(fuente);
        efectivoPane.add(bido,0,3);

        Label cam = new Label("Cambio:");
        cam.setFont(fuente);
        efectivoPane.add(cam,1,0);

        bio = new TextField();
        bio.setEditable(false);
        bio.setFont(fuente);
        efectivoPane.add(bio, 1,1);
        efectivoPane.setHgap(5);
        efectivoPane.setVgap(5);

        // Boton calcular
        Button boton = new Button("Calcular");
        boton.setFont(fuente);
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int reci = Integer.parseInt(bido.getText());
                int pago = Integer.parseInt(APagar.getText());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Que plomo");
                alert.setHeaderText("Pago insuficiente LMAO");
                alert.setContentText("Introduzca una cantidad valida");

                if (reci < pago){
                    bido.setText("");
                    alert.showAndWait();
                }
                else{
                    int cam = reci - pago;
                    bio.setText(String.valueOf(cam));
                }
            }
        });
        efectivoPane.add(boton,1,2);

        efectivoPane.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");

        // panel con los parametros de la tarjeta
        todoLoDemas = new GridPane();
        todoLoDemas.setStyle("-fx-padding: 6;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: grey;");
        todoLoDemas.setVgap(4);
        todoLoDemas.setHgap(5);

        Label numTar = new Label("Numero de tarjeta:");
        numTar.setFont(fuente);
        todoLoDemas.add(numTar, 0,0);

        numero = new TextField();
        numero.setFont(fuente);
        todoLoDemas.add(numero, 1,0);

        Label codigoSeg = new Label("Codigo De Seguridad:");
        codigoSeg.setFont(fuente);
        todoLoDemas.add(codigoSeg, 0, 1);

        codigo = new TextField();
        codigo.setFont(fuente);
        todoLoDemas.add(codigo, 1,1);

        Label nombreLabel = new Label("Nombre Trajeta habiente:");
        nombreLabel.setFont(fuente);
        todoLoDemas.add(nombreLabel, 0,2);

        nombre = new TextField();
        nombre.setFont(fuente);
        todoLoDemas.add(nombre, 1,2);

        Label fecha = new Label("Fecha de vencimiento:");
        fecha.setFont(fuente);
        todoLoDemas.add(fecha,0  ,3);

        ComboBox meses = new ComboBox();
        meses.getItems().addAll("","Enero", "Febrero", "Marzo", "Abril", "Mayo","Junio",
                "Julio", "Agosto","Septiembre", "Octubre", "Noviembre", "Diciembre");
        todoLoDemas.add(meses, 1,3);

        ComboBox anios = new ComboBox();
        anios.getItems().addAll("", "2018", "2019", "2020", "2021", "2022", "2023");
        todoLoDemas.add(anios,2,3);

        Label domicilio = new Label("Domicilio");
        domicilio.setFont(fuente);
        todoLoDemas.add(domicilio,0,4);

        Label calleLabel = new Label("Calle:");
        calleLabel.setFont(fuente);
        todoLoDemas.add(calleLabel, 0, 5);

        calle =new TextField();
        calle.setFont(fuente);
        todoLoDemas.add(calle, 1,5);

        Label numCalle = new Label("Num:");
        numCalle.setFont(fuente);
        todoLoDemas.add(numCalle,2,5);

        numeroCalle = new TextField();
        numeroCalle.setFont(fuente);
        todoLoDemas.add(numeroCalle, 3,5);

        Label Colonia = new Label("Colonia:");
        Colonia.setFont(fuente);
        todoLoDemas.add(Colonia, 0 ,6);

        colonia = new TextField();
        colonia.setFont(fuente);
        todoLoDemas.add(colonia, 1,6);

        Label Ciudad = new Label("Ciudad:");
        Ciudad.setFont(fuente);
        todoLoDemas.add(Ciudad, 3,6);

        ciudad = new TextField();
        ciudad.setFont(fuente);
        todoLoDemas.add(ciudad, 4,6);

        Label Estado = new Label("Estado:");
        Estado.setFont(fuente);
        todoLoDemas.add(Estado,0,7);

        estado = new TextField();
        estado.setFont(fuente);
        todoLoDemas.add(estado, 1,7);

        Label pais = new Label("Pais:");
        pais.setFont(fuente);
        todoLoDemas.add(pais, 2,7);

        ComboBox paises = new ComboBox();
        paises.getItems().addAll("", "Cuba", "Venezuela", "China", "Corea del Norte", "Paraguay");
        todoLoDemas.add(paises, 3,7);

        Button enviar = new Button("Enviar");
        enviar.setFont(fuente);
        todoLoDemas.add(enviar, 4, 3);

        enviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Que plomo");
                alerta.setHeaderText("Input invalido LMAO");
                alerta.setContentText("Introduzca un input valido");

                if (numero.getLength() < 16|| codigo.getLength() < 3|| nombre.getLength() < 8 ) alerta.showAndWait();
                else {
                    System.out.println("numero de tarjeta: "+numero.getText());
                    System.out.println("Codigo de seguridad: "+codigo.getText());
                    System.out.println("Nombre del cholo: "+ nombre.getText());
                }
            }
        });

        // se desabilitan los paneles
        TarjetaPanel.setDisable(true);
        efectivoPane.setDisable(true);
        todoLoDemas.setDisable(true);

        // se añnaden los panes al panel que se añade a la escena
        root.add(pago,0,0);
        root.add(TarjetaPanel,1,0);
        root.add(efectivoPane,2,0);
        root.add(todoLoDemas,0,1, 3,3);

        // se establecen el tamaño de la root y el stage
        root.setMinHeight(700);
        root.setMinWidth(1040);
        stage.setWidth(1040);
        stage.setHeight(700);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(1040);
        stage.setHeight(700);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
