package com.company;
import com.company.ConverterIf;
import com.company.ConverterSwitch;

/*Task:
 *
 */
public class ConverterApplication {

    public static void main(String[] args) {
        ConverterIf ifConversion = new ConverterIf();
        ConverterSwitch switchConversion = new ConverterSwitch();
        //If converter implementation
        ifConversion.convertDay(5);
        ifConversion.convertMonth(11);
        //Switch converter implementation
        switchConversion.convertMonth(3);
        switchConversion.convertDay(2);

    }
}
