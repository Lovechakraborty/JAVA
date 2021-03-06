import java.util.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

interface Converter{
   public double convert(double t);
}

abstract class TemperatureConverter implements Converter{
  abstract protected boolean isHot(double temparature);
}

abstract class SpeedConverter implements Converter{
   abstract protected boolean isFast(double Speed);
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
                     //converter.isHot(50.6);
                     t1.convert(8.7);
                     t1.isHot(50.6);
                   break;
                 case 2:
                     System.out.println("Input 2");
                     converter1.convert(4.7);
                     //converter1.isHot(80.5);
                     t2.convert(4.7);
                     t2.isHot(80.5);
                   break;
                 case 3:
                     System.out.println("Input 3");
                     converter1.convert(7.8);
                     //converter1.isFast(40.7);
                     p1.convert(4.7);
                     p1.isFast(40.7);
                   break;
                 case 4:
                     System.out.println("Input 4");
                     converter3.convert(8.5);
                     //converter1.isFast(100.7);
                     st.convert(8.5);
                     st.isFast(100.7);
                   break;
                 default:
                     System.out.println("Wrong Input");
                     break;
               }
                   
       }
       catch (NoSuchElementException exception) {
            
        } catch (Exception exception) {
            
        }
        
   }
}
      
