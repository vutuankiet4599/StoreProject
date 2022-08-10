/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DataTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyDate md[] = new MyDate[10];
        MyDate md1 = new MyDate("First", "May", "Twenty Nine");
        md1.print();
        md1.print_date_string();
        System.out.println("Before sort:");
        for(int i = 0; i < 10; i++){
            md[i] = new MyDate(i+1, i+1, i+1);
            md[i].print();
            md[i].print_date_string();
        }
        
        md = DateUtils.sort(md);
        System.out.println("After sort");
        for(int i = 0; i < 10; i++){
            md[i].print();
            md[i].print_date_string();
        }
    }
    
}
