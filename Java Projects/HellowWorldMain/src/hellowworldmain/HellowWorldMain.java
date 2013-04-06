/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellowworldmain;

import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CheckMenuItemBuilder;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.CycleMethod;
import javafx.scene.text.Font;
import javafx.scene.shape.*;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.LinearGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.RadialGradientBuilder;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.RadioMenuItemBuilder;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Lionel Guimaraes
 */
public class HellowWorldMain extends Application {
    
    @Override
    public void start(Stage primaryStage) 
    { 
//        ex1(primaryStage);
//        ex2();
//        ex3();
//        ex4();
//        ex5();
//        ex6();
//        ex7();
        ex8();
    }
    
    
    public void ex1(Stage primaryStage)
    {
        primaryStage.setTitle("Chapter 1-3 Drawing Text");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);
        Random rand = new Random(System.currentTimeMillis());

        for( int i =0; i < 100; i++)
        {
            int x = rand.nextInt( (int) scene.getWidth() );
            int y = rand.nextInt( (int) scene.getHeight() );
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);

            Text text = new Text(x, y, "JavaFX 2.0");

            int rot = rand.nextInt(360);
            text.setFill(Color.rgb(red, green, blue, 0.99));
            text.setRotate(rot);
            root.getChildren().add(text);
        }

        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    
    public void ex2()
    {
        Stage secondaryStage = new Stage();
        
        secondaryStage.setTitle("Chapter 1-4 Changing Text Fonts");
        Group root2 = new Group();
        Scene scene2 = new Scene(root2, 550, 250, Color.WHITE);

        // Serif with drop shadow
        Text text2 = new Text(50, 50, "JavaFX 2.0: Intro. by Example");
        Font serif = Font.font("Serif", 30);
        text2.setFont(serif);
        text2.setFill(Color.RED);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0f);
        dropShadow.setOffsetY(2.0f);
        dropShadow.setColor(Color.rgb(50, 50, 50, 0.588));
        text2.setEffect(dropShadow);
        root2.getChildren().add(text2);

        // Sanserif
        Text text3 = new Text(50, 100, "JavaFX 2.0: Intro. by Example");
        Font sanSerif = Font.font("SanSerif", 30);
        text3.setFont(sanSerif);
        text3.setFill(Color.BLUE);
        root2.getChildren().add(text3);

        // Dialog
        Text text4 = new Text(50, 150, "JavaFX 2.0: Intro. by Example");
        Font dialogFont = Font.font("Dialog", 30);
        text4.setFont(dialogFont);
        text4.setFill(Color.rgb(0, 255, 0));
        root2.getChildren().add(text4);

        // Monospaced
        Text text5 = new Text(50, 200, "JavaFX: Intro. by Example");
        Font monoFont = Font.font("Monospaced", 30);
        text5.setFont(monoFont);
        text5.setFill(Color.BLACK);
        root2.getChildren().add(text5);

        Reflection refl = new Reflection();
        refl.setFraction(0.8f);
        text5.setEffect(refl);

        secondaryStage.setScene(scene2);
        secondaryStage.show();  
    }
    
    public void ex3()
    {
        Stage primaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 200, 600);
        
         // CubicCurve
        CubicCurve cubicCurve = CubicCurveBuilder.create()
                .startX(50).startY(75)          // start pt (x1, y1)
                .controlX1(80).controlY1(-25)   // control pt1
                .controlX2(80).controlY2(175)   // control pt2
                .endX(140).endY(75)             // end pt (x2, y2)
                .strokeType(StrokeType.CENTERED).strokeWidth(1)
                .stroke(Color.BLACK)
                .strokeWidth(3)
                .fill(Color.WHITE)
                .build();
        
        root.getChildren().add(cubicCurve);
        
        // Ice Cream
        Path path = new Path();
        
        MoveTo moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(150);
        
        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(150);
        quadCurveTo.setY(150);
        quadCurveTo.setControlX(100);
        quadCurveTo.setControlY(50);
        
        LineTo lineTo1 = new LineTo();
        lineTo1.setX(50);
        lineTo1.setY(150);
        
        LineTo lineTo2 = new LineTo();
        lineTo2.setX(100);
        lineTo2.setY(275);
        
        LineTo lineTo3 = new LineTo();
        lineTo3.setX(150);
        lineTo3.setY(150);
        
        path.getElements().add(moveTo);
        path.getElements().add(quadCurveTo);
        path.getElements().add(lineTo1);
        path.getElements().add(lineTo2);
        path.getElements().add(lineTo3);
        path.setTranslateY(30);
        path.setStrokeWidth(3);
        path.setStroke(Color.BLACK);
        
        root.getChildren().add(path);
        
        // QuadCurve create a smile
        QuadCurve quad = QuadCurveBuilder.create()
                .startX(50)
                .startY(50)
                .endX(150)
                .endY(50)
                .controlX(125)
                .controlY(150)
                .translateY(path.getBoundsInParent().getMaxY())
                .strokeWidth(3)
                .stroke(Color.BLACK)
                .fill(Color.WHITE)
                .build();
        
        root.getChildren().add(quad);
        
        // out donut
        Ellipse bigCircle = EllipseBuilder.create()
                .centerX(100)
                .centerY(100)
                .radiusX(50)
                .radiusY(75/2)
                .translateY(quad.getBoundsInParent().getMaxY())
                .strokeWidth(3)
                .stroke(Color.BLACK)
                .fill(Color.WHITE)
                .build();
        
        // donut hole
        Ellipse smallCircle = EllipseBuilder.create()
                .centerX(100)
                .centerY(100)
                .radiusX(35/2)
                .radiusY(25/2)
                .build();
        
        // make donut
        Shape donut = Path.subtract(bigCircle, smallCircle);
        
        // orange glaze
        donut.setFill(Color.rgb(255, 200, 0));
        
        // add drop shadow
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0f);
        dropShadow.setOffsetY(2.0f);
        dropShadow.setColor(Color.rgb(50, 50, 50, 0.588));
        donut.setEffect(dropShadow);
        
        // move slightly down
        //donut.setTranslateY(quad.getBoundsInParent().getMaxY());
        
        root.getChildren().add(donut);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public void ex4()
    {
        Stage primaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 350, 300, Color.WHITE);
        
        primaryStage.setTitle("Chapter 1-6 Assigning Colours to Objects");
        
        Ellipse ellipse = new Ellipse( 100, 50 + 70/2, 50, 70/2 );
        RadialGradient gradient1 = RadialGradientBuilder.create()
                .focusAngle( 0 )
                .focusDistance( 0.1 )
                .centerX( 80 )
                .centerY( 45 ) 
                .radius( 120 )
                .proportional( false )
                .cycleMethod( CycleMethod.NO_CYCLE )
                .stops( new Stop( 0, Color.RED ), new Stop( 1, Color.BLACK ) )
                .build();
        
        ellipse.setFill( gradient1 );
        root.getChildren().add( ellipse );
        
        Line blackLine = LineBuilder.create()
                .startX( 170 )
                .startY( 30 )
                .endX( 20 )
                .endY( 140 )
                .fill( Color.BLACK )
                .strokeWidth( 10.0f )
                .translateY( ellipse.prefHeight( -1 ) + ellipse.getLayoutY() + 10 )
                .build();
        
        root.getChildren().add( blackLine );
        
        
        Rectangle rectangle = RectangleBuilder.create()
                .x( 50 )
                .y( 50 )
                .width( 100 )
                .height( 70 )
                .translateY( ellipse.prefHeight( -1 ) + ellipse.getLayoutY() + 10 )
                .build();
        
        LinearGradient linearGradient = LinearGradientBuilder.create()
                .startX( 50 )
                .startY( 50 )
                .endX( 50 )
                .endY( 50 + rectangle.prefHeight( -1 ) + 25 )
                .proportional( false )
                .cycleMethod( CycleMethod.NO_CYCLE )
                .stops( new Stop( 0.1f, Color.rgb( 255, 200, 0, 0.784) ), 
                        new Stop( 1.0f, Color.rgb( 0, 0, 0, 0.784) ) )
                .build();
        
        rectangle.setFill( linearGradient );
        root.getChildren().add( rectangle );
        
        Rectangle roundRect = RectangleBuilder.create()
                .x( 50 )
                .y( 50 )
                .width( 100 )
                .height( 70 )
                .arcWidth( 20 )
                .arcHeight( 20 )
                .translateY( ellipse.prefHeight( -1 ) + ellipse.getLayoutY() + 10
                             + rectangle.prefHeight( -1 ) + rectangle.getLayoutY() + 10 )
                .build();
         
        LinearGradient cycleGrad = LinearGradientBuilder.create()
                .startX( 50 )
                .startY( 50 )
                .endX( 70 )
                .endY( 70 )
                .proportional( false )
                .cycleMethod( CycleMethod.REFLECT )
                .stops( new Stop( 0f, Color.rgb( 0, 255, 0, 0.788 ) ),
                        new Stop( 1.0f, Color.rgb( 0, 0, 0, 0.784) ) )
                .build();
        
        roundRect.setFill( cycleGrad );
        root.getChildren().add( roundRect );
        
        primaryStage.setScene( scene );
        primaryStage.show();
    }
    
    
    public void ex5()
    {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Chapter 1-7 Creating Menus");
        
        Group root = new Group();
        Scene scene = new Scene( root, 300, 250, Color.WHITE );
        
        MenuBar menuBar = new MenuBar();
        
        // File menu - new, save, exit
        Menu menu = new Menu( "File" );
        menu.getItems().add( new MenuItem( "New" ) );
        menu.getItems().add( new MenuItem( "Save" ) );
        menu.getItems().add( new SeparatorMenuItem() );
        menu.getItems().add( new MenuItem( "Exit" ) );
        
        menuBar.getMenus().add( menu );
        
        // Cameras menu - camera 1, camera 2   
        Menu tools = new Menu( "Cameras" );
        tools.getItems().add( CheckMenuItemBuilder.create()
                              .text( "Show Camera 1" )
                              .selected( true )
                              .build() );
        tools.getItems().add( CheckMenuItemBuilder.create()
                              .text( "Show Camera 2" )
                              .selected( true )
                              .build() );
        menuBar.getMenus().add( tools );
        
        
        // Alarm
        Menu alarm = new Menu( "Alarm" );
        ToggleGroup tGroup = new ToggleGroup();
        
        RadioMenuItem soundAlarmItem = RadioMenuItemBuilder.create()
                                       .toggleGroup(tGroup)
                                       .text( "Sound Alarm ")
                                       .build();
        
        RadioMenuItem stopAlarmItem = RadioMenuItemBuilder.create()
                                      .toggleGroup(tGroup)
                                      .text( "Alarm Off" )
                                      .selected(true)
                                      .build();
        
        alarm.getItems().add(soundAlarmItem);
        alarm.getItems().add(stopAlarmItem);
        
        
        Menu contingencyPlans = new Menu( "Contingent Plans" );
        contingencyPlans.getItems().add( new CheckMenuItem( "Self Destruct in T minus 50" ) );
        contingencyPlans.getItems().add( new CheckMenuItem( "Turn off the coffee machine " ) );
        contingencyPlans.getItems().add( new CheckMenuItem( "Run for your lives!" ) );
        
        alarm.getItems().add( contingencyPlans );
        menuBar.getMenus().add(alarm);
        menuBar.prefWidthProperty().bind( primaryStage.widthProperty() );
        
        root.getChildren().add( menuBar );
        primaryStage.setScene( scene );
        primaryStage.show();
    }
    
    
    public void ex6()
    {
        Stage primaryStage = new Stage();
        primaryStage.setTitle( "Chapter 1-8 Adding Component to a Layout" );
        Group root = new Group();
        Scene scene = new Scene( root );//, 400, 350, Color.WHITE );
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding( new Insets( 5 ) );
        gridPane.setHgap( 5 );
        gridPane.setVgap( 5 );
        
        Label fNameLb1 = new Label( "First Name" );
        TextField fNameFld = new TextField();
        Label lNameLb1 = new Label( "Last Name" );
        TextField lNameFld = new TextField();
        Button saveButt = new Button( "Save" );
        
        // First name Label
        GridPane.setHalignment( fNameLb1, HPos.RIGHT );
        gridPane.add( fNameLb1, 0, 0 );
        
        // Last name Label
        GridPane.setHalignment( lNameLb1 , HPos.RIGHT);
        gridPane.add( lNameLb1 , 0, 1 );
        
        // First name Field
        GridPane.setHalignment( fNameFld , HPos.LEFT );
        gridPane.add( fNameFld , 1, 0 );
        
        // Last Name Field
        GridPane.setHalignment( lNameFld , HPos.LEFT);
        gridPane.add( lNameFld, 1, 1 );
        
        // Save Button
        GridPane.setHalignment( saveButt, HPos.RIGHT );
        gridPane.add( saveButt, 1, 2 ); 
        
        root.getChildren().add( gridPane );
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public void ex7()
    {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Chapter 1-9 Generating Borders");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 350, Color.WHITE);
        
        // create grid pane
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        
        // label CSS Editor
        Label cssEditorLbl = new Label("CSS Editor");
        GridPane.setHalignment(cssEditorLbl, HPos.CENTER);
        gridpane.add(cssEditorLbl, 0, 0);
        
        // label Border View
        Label borderLbl = new Label("Border View");
        GridPane.setHalignment(borderLbl, HPos.CENTER);
        gridpane.add(borderLbl, 1, 0);
        
        // Text area for CSS editor
        final TextArea cssEditorFld = new TextArea();
        cssEditorFld.setPrefRowCount(10);
        cssEditorFld.setPrefColumnCount(100);
        cssEditorFld.setWrapText(true);
        cssEditorFld.setPrefWidth(150);
        GridPane.setHalignment(cssEditorFld, HPos.CENTER);
        gridpane.add(cssEditorFld, 0, 1);
        
        String cssDefault = "-fx-border-color:blue;\n"
                            + "-fx-border-insets: 5;\n"
                            + "-fx-border-width: 10;\n"
                            + "-fx-border-style: dashed;\n";
        cssEditorFld.setText(cssDefault);
        
        // Border decorate the picture
        final ImageView imv = new ImageView();
        final Image image2 = new Image(HellowWorldMain.class.getResourceAsStream("smoke_glass_buttons1.png"));
        imv.setImage(image2);
        
        final HBox pictureRegion = new HBox();
        pictureRegion.setStyle(cssDefault);
        pictureRegion.getChildren().add(imv);
        gridpane.add(pictureRegion, 1, 1);
        
        Button apply = new Button("Bling!");
        GridPane.setHalignment(apply, HPos.RIGHT);
        gridpane.add(apply, 0, 2);
        
        apply.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) 
                {
                pictureRegion.setStyle( cssEditorFld.getText() );
                }
            });
                                 
        root.getChildren().add(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public void ex8()
    {
        System.out.println("Chapter 1-10 Binding Expressions\n");
        
        System.out.println("Binding a Contact bean [Bi-directional binding]");
        Contact contact = new Contact("John", "Doe");
        StringProperty fname = new SimpleStringProperty();
        fname.bindBidirectional( contact.getFirstNameProperty() );
        StringProperty lname = new SimpleStringProperty();
        lname.bindBidirectional( contact.getLastNameProperty() );
        
        System.out.println("Current - StringProperty value : " 
                            + fname.getValue() + " "
                            + lname.getValue() );
        System.out.println("Current Contact values : "
                            + contact.getFirstName() + " "
                            + contact.getLastName() );
        
        System.out.println("Modifying StringProperty values");
        fname.setValue("Jane");
        lname.setValue("Deer");
        
        System.out.println("After - StringProperty values : "
                            + fname.getValue() + " "
                            + lname.getValue() );
        System.out.println("After - Contact values : "
                            + contact.getFirstName() + " "
                            + contact.getLastName() );
        
        System.out.println();
        System.out.println("A Area of a Rectangle [ High level Fluent API]");
        
        // Area = width * height
        final IntegerProperty width = new SimpleIntegerProperty( 10 );
        final IntegerProperty height = new SimpleIntegerProperty( 10 );
        
        NumberBinding area = width.multiply(height);
        
        System.out.println("Current - Width and Height : "
                            + width.get()  + " "
                            + height.get() );
        System.out.println("Current - Area of the Rectangle: "
                            + area.getValue() );
        
        System.out.println("Modifying width and height");
        width.set( 100 );
        height.set( 700 );
        
        System.out.println("After - Width and Height : "
                            + width.get() + " "
                            + height.get() );
        System.out.println("After - Area of Rectangle : "
                            + area.getValue() );
        
        System.out.println();
        System.out.println("A Volume of a Sphere [low level API]");
        
        // Volume = 4/3 * pi * r^3
        final DoubleProperty radius = new SimpleDoubleProperty( 2 );
        
        DoubleBinding volumeOfSphere = new DoubleBinding()
        {
            {
                super.bind( radius );
            }
            
            @Override
            protected double computeValue() 
            {
                return( 4/3 * Math.PI * Math.pow( radius.get(), 3) );
            }
        };
        
        System.out.println("Current - radius for Sphere: "
                            + radius.get() );
        System.out.println("Current - volume for Sphere: "
                            + volumeOfSphere.get() );
        
        System.out.println("Modifying DoubleProperty radius");
        radius.set( 50 );
        
        System.out.println("After - radius for Sphere: "
                            + radius.get() );
        System.out.println("After - volume for Sphere: "
                            + volumeOfSphere.get() );
    }
    
    class Contact
    {
        private SimpleStringProperty firstName = new SimpleStringProperty();
        private SimpleStringProperty lastName = new SimpleStringProperty();
        
        public Contact(String fn, String ln)
        {
            firstName.setValue(fn);
            lastName.setValue(ln);
        }
        
        public final String getFirstName()
        {
            return firstName.getValue();
        }
        
        public final StringProperty getFirstNameProperty()
        {
            return firstName;
        }
        
        public final void setFirstName(String firstName)
        {
            this.firstName.setValue(firstName);
        }
        
        public final String getLastName()
        {
            return lastName.getValue();
        }
        
        public final StringProperty getLastNameProperty()
        {
            return lastName;
        }
        
        public final void setLastName(String lastName)
        {
            this.lastName.setValue(lastName);
        }
    }
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
