/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author AjiboyeGbemileke
 */
public class MainController implements Initializable {
    public static final double PIE = (22/7);
    private static double input1;
    private static boolean noError=true;
    private static char operator;
    @FXML
    private TextField display ;
    @FXML
    private Button exp;//c0ntinue from this
    @FXML
    private Button asin;
    @FXML
    private Button acos;
    @FXML
    private Button atan;
    @FXML
    private Button tenpx;
    
    
    @FXML
    private void handleNumbers(ActionEvent event) {
        //display.setText(display.getText()+((Button)event.getSource()).getText());
        Object object = event.getSource();
        if (object instanceof Button){
        Button button = (Button) object;
        String oldText= display.getText();
        String newText = button.getText();
        newText=oldText+newText;
        display.setText(newText);
        }
    }
    @FXML
     private void arithematic(ActionEvent event) {
        Object object = event.getSource();
        if (object instanceof Button){
            Button button = (Button) object;
            operator= button.getText().charAt(0);
            input1=Double.parseDouble(display.getText());
            display.setText("");
        }
    }
        @FXML
        private void equals(ActionEvent event) {
            switch(operator){
                case '/':
                    if(Double.parseDouble(display.getText())!=0){
                        input1/=Double.parseDouble(display.getText());
                        display.setText(Double.toString(input1));
                    }
                    else{
                        display.setText("Math ERROR");
                        noError=false;
                    }
                break;
                 case 'x':
                    input1*=Double.parseDouble(display.getText());
                    display.setText(Double.toString(input1));
                break;
                 case '+':
                    input1+=Double.parseDouble(display.getText());
                    display.setText(Double.toString(input1));
                break;
                 case '-':
                    input1-=Double.parseDouble(display.getText());
                    display.setText(Double.toString(input1));
                break;
            }
        }
        @FXML
        private void AC(ActionEvent event) {
        input1=0;
        display.setText("");
        }
        @FXML
        private void DEl(ActionEvent event) {
            String text=display.getText();
            text= text.substring(0,text.length()-1);
            display.setText(text);
        }
        @FXML
        private void fact(ActionEvent event) {
            input1=calcFact(Long.parseLong(display.getText()));
            display.setText(Double.toString(input1));
		}
	private static long calcFact(long x){
		if (x<=1){
			return 1;
		}
		else{
			return x*calcFact(x-1);
		}
	}
        @FXML
        private void ScientificFuntion(ActionEvent event) {
            if(event.getSource() instanceof Button){
                Button btn=(Button)(event.getSource());
                switch(btn.getText()){
                    case "sin": input1=Double.parseDouble(display.getText());
                                input1=Math.toRadians(input1);
                                input1=Math.sin(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "cos":input1=Double.parseDouble(display.getText());
                                input1=Math.toRadians(input1);
                                input1=Math.cos(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "tan":input1=Double.parseDouble(display.getText());
                                input1=Math.toRadians(input1);
                                input1=Math.tan(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "sinh":input1=Double.parseDouble(display.getText());
                                input1=Math.sinh(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "cosh":input1=Double.parseDouble(display.getText());
                                input1=Math.cosh(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "tanh":input1=Double.parseDouble(display.getText());
                                input1=Math.tanh(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "ln":input1=Double.parseDouble(display.getText());
                                input1=Math.log(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "log":input1=Double.parseDouble(display.getText());
                                input1=Math.log10(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "asin":input1=Double.parseDouble(display.getText());
                                input1=Math.asin(input1);
                                input1=Math.toDegrees(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "acos":input1=Double.parseDouble(display.getText());
                                input1=Math.acos(input1);
                                input1=Math.toDegrees(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "atan":input1=Double.parseDouble(display.getText());
                                input1=Math.atan(input1);
                                input1=Math.toDegrees(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "exp":input1=Double.parseDouble(display.getText());
                                input1=Math.exp(input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "10x":input1=Double.parseDouble(display.getText());
                                input1=Math.pow(10,input1);
                                display.setText(Double.toString(input1));
                    break;
                    case "shift":
                        if(asin.getText().equals("sin")){
                            exp.setText("exp");
                            asin.setText("asin");
                            acos.setText("acos");
                            atan.setText("atan");
                            tenpx.setText("10x");
                         }else{
                            exp.setText("ln");
                            asin.setText("sin");
                            acos.setText("cos");
                            atan.setText("tan");
                            tenpx.setText("log");
                        }
                    break;
                        
                }
            
                
            }
            
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
