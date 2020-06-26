import java.util.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

interface Converter{
   public double convert(double t);
}

abstract class TemperatureConverter implements Converter{
  abstract protected boolean isHot(double temparature);
   // public double convert(double t){
   //    System.out.println("convert Celsius to Fahrenheit and Celsius to Kelvin respectively");
   //    return t;
   // }
   
}

abstract class SpeedConverter implements Converter{
   abstract protected boolean isFast(double Speed);
   // public double convert(double sp){
   //    System.out.println("convert Celsius to Fahrenheit and Celsius to Kelvin respectively");
   //    return sp;
   // }
}

class Thermometer extends TemperatureConverter{
   protected boolean isHot(double temparature){
            if(temparature>50){
                System.out.println("Thermometer Temparature is: "+temparature);
                System.out.println(" Hot Temparature ");
                return true;
            }
            else{
             System.out.println("Thermometer Temparature is: "+temparature);
             System.out.println("Not So Hot ");
             return false;
            }
   }
@Override
   public double convert(double t){
       t = (t * 9.0 / 5.0) + 32.0;
      System.out.println("convert Celsius to Fahrenheit: "+t);
      return t; 
   }

}

class Thermocouple extends TemperatureConverter{
   protected boolean isHot(double temparature){
        if(temparature>50){
                System.out.println("Thermocouple Temparature is: "+temparature);
                System.out.println(" Hot Temparature ");
                return true;
            }
            else{
             System.out.println("Thermocouple Temparature is: "+temparature);
             System.out.println("Not So Hot ");
             return false;
            }
   }
@Override
   public double convert(double t){
      t = t + 273.15;
      System.out.println("convert Celsius to Kelvin: "+t);
      return t;
   }
}

 class PitotTube extends SpeedConverter{
 protected boolean isFast(double speed){
            if(speed>100){
                System.out.println("PitotTube Speed is: "+speed);
                System.out.println(" Fast Speed ");
                return true;
            }
            else{
             System.out.println("PitotTube Speed is: "+speed);
             System.out.println("Not So Fast ");
             return false;
            }
 }
  @Override
   public double convert(double kms){
      kms = kms / 1225;
      System.out.println("convert kms to mach: "+kms);
      return kms;
   }

}

class ShaftLog  extends SpeedConverter{
  protected boolean isFast(double speed){
     if(speed>100){
                System.out.println("ShaftLog Speed is: "+speed);
                System.out.println(" Fast Speed ");
                return true;
            }
        else{
             System.out.println("ShaftLog Speed is: "+speed);
             System.out.println("Not So Fast ");
             return false;
            }
  }
  @Override
   public double convert(double kmh){
       kmh = 0.6213712 * kmh; 
       System.out.println("convert kmh to mph: "+kmh);
      return kmh;
   }
   
}

public class Main{
   public static void main(String args[]){
       try{
 
           Converter converter = new Thermometer();
           Thermometer t1 = (Thermometer) converter;
           
           Converter converter1 = new Thermocouple();
           Thermocouple t2 = (Thermocouple) converter1;
           
           Converter converter2 = new PitotTube();
           PitotTube p1 = (PitotTube) converter2;
           
           Converter converter3 = new ShaftLog();
           ShaftLog st = (ShaftLog) converter3;
     
              Scanner s1 = new Scanner(System.in);
              System.out.println("Enter an input from 1 to 4: ");
              int num;
              num= s1.nextInt();
              System.out.println("Input is: "+num);
              switch (num) {
                 case 1:
                     System.out.println("Input 1");
                     converter.convert(8.7);
                     t1.isHot(50.6);
                      //Thermometer t1;
                   break;
                 case 2:
                     System.out.println("Input 2");
                     converter1.convert(4.7);
                     t2.isHot(80.5);
                     //Thermocouple t2;
                   break;
                 case 3:
                     System.out.println("Input 3");
                     converter2.convert(7.5);
                     p1.isFast(40.7);
                    // PitotTube p1;
                   break;
                 case 4:
                     System.out.println("Input 4");
                     converter3.convert(8.5);
                     st.isFast(100.5);
                    // ShaftLog s1;
                   break;
                 default:
                     System.out.println("Wrong Input");
                     break;
               }
                   
       }
       catch (NoSuchElementException exception) {
            // Output expected NoSuchElementExceptions.
           // log(exception);
        } catch (Exception exception) {
            // Output unexpected Exceptions.
            //log(exception, false);
        }
        
   }
}
      
