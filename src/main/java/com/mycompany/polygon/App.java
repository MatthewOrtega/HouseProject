package com.mycompany.polygon;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {
  
Group group;
GraphicsContext gc;
  
   // launch the application to build the house.
    /**
     *
     * @param stage
     */
@Override
   public void start(Stage stage)
   {
       stage.setTitle("Creating Canvas");
       // create the canvas.
       Canvas canvas = new Canvas(600.0f, 600.0f);
       // graphics context.
       gc = canvas.getGraphicsContext2D();   
       // create a Group.
       group = new Group(canvas);
        draw1();
       // create a scene.
       Scene scene = new Scene(group, 600, 600);
       // set the scene.
       stage.setScene(scene);
       stage.show();
   }
  
   public void draw1()
   {
//sky
gc.setFill(Color.SKYBLUE);
gc.fillRect(0, 0, 600, 250);

//lawn
gc.setFill(Color.GREEN);
gc.fillRect(0, 250, 600, 600);
  
//roof triangle
Polyline triangle = new Polyline();
triangle.getPoints().addAll(new Double[]{
300.0, 0.0, //clockwise points of triangle
550.0, 150.0,
50.0, 150.0,
300.0, 0.0, }); //same as first
triangle.setStroke(Color.BLACK);
triangle.setFill(Color.WHITE);
group.getChildren().add(triangle);
  
//rectangle below triangle
Rectangle rect = new Rectangle(70, 150, 460, 30);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
//rectangle wall
rect = new Rectangle(70, 180, 460, 330);
rect.setFill(Color.BROWN);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);

//gray center window 
rect = new Rectangle(260, 210, 80, 40);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
//left door 
rect = new Rectangle(125, 295, 80, 165);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//left blacks
doorblacks(142, 310);
//left pillar
pillar(80, 180);
  
//middle door
rect = new Rectangle(260, 275, 80, 190);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//middle blacks
doorblacks(277, 310);
//middle pillar
pillar(215, 180);
  
//right door
rect = new Rectangle(395, 295, 80, 165);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//right blacks
doorblacks(412, 310);
//right pillar
pillar(350, 180);
//last pillar
pillar(485, 180);
  
//first rectangle below doors
rect = new Rectangle(70, 460, 460, 5);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
stairs(120, 460);
  
//Sun
//gc.setFill(Color.ORANGE);
//gc.fillOval(30, 30, 70, 70);
      
   }
public void doorblacks(int x, int y)
{
Rectangle rect;
  
for(int i = 0, j=0; i<5; i++, j+=30)
{
//black left
rect = new Rectangle( x, y+j, 15, 25 ); 
rect.setFill(Color.BLACK);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//black right  
rect = new Rectangle( x+30, y+j, 15, 25 ); 
rect.setFill(Color.BLACK);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
}
}
  
public void pillar(int x, int y)
{
Rectangle rect;
int width=35, height=270;
//pillar  
rect = new Rectangle( x, y, width, height ); 
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//pillar base  
rect = new Rectangle( x-5, y+height, 45, 10 ); 
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
//circles
Circle circle1 = new Circle();
//setting the properties of the first circle
int radius=11;
circle1.setFill(Color.WHITE);
circle1.setStroke(Color.BLACK);
circle1.setRadius(radius);
circle1.setCenterX(x);
circle1.setCenterY(y+radius);
group.getChildren().add(circle1);

Circle circle2 = new Circle();
//setting the properties of the second circle   
circle2.setFill(Color.WHITE);
circle2.setStroke(Color.BLACK);
circle2.setRadius(radius);
circle2.setCenterX(x+width);
circle2.setCenterY(y+radius);
group.getChildren().add(circle2);
}
  
public void stairs(int x, int y)
{
Rectangle rect;
int width=360, height=10;
  
for(int i=1; i<=11; i++)
{
rect = new Rectangle(x, y, width, 10);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);   
x= x-10; //decrease x for next stair by 10
y= y+height; //increase y for next stair
width = width + 20; //increase width (y) for next stair by 10
}
}
   // Main Method
   public static void main(String args[])
   {
// launch the application
launch(args);
   }
}