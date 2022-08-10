package hust.soict.hedspi.aims.utils;

import static java.lang.System.exit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = java.time.LocalDate.now().getDayOfMonth();
        this.month = java.time.LocalDate.now().getMonthValue();
        this.year = java.time.LocalDate.now().getYear();
    }

    public MyDate(int day, int month, int year) {
        
        if(year > 0){
            this.year = year;
        }else{
            System.out.println("Your year is invalid");
            exit(0);
        }
        switch(month){
            case 1:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 1;
                break;
            case 2:
                if(year % 100 == 0){
                    if(year % 400 == 0){
                        if(day > 29 || day <= 0){
                            System.out.println("Your day is invalid");    
                            exit(0);
                        }else{
                            this.day = day;
                        }
                    }else{
                        if(day > 28 || day <= 0){
                            System.out.println("Your day is invalid");
                            exit(0);
                        }else{
                            this.day = day;
                        }
                    }
                }else if(year % 4 == 0){
                    if(day > 29 || day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }else{
                        this.day = day;
                    }
                }else{
                    if(day > 28 || day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }else{
                        this.day = day;
                    }
                }
                this.month = 2;
                break;
            case 3:                
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 3;
                break;
            case 4:
                if(day > 30 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                this.month = 4;
                break;
            case 5:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 5;
                break;
            case 6:
                if(day > 30 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 6;
                break;
            case 7:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 7;
                break;
            case 8:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 8;                        
                break;
            case 9:
                if(day > 30 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 9;
                break;
            case 10:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 10;
                break;
            case 11:
                if(day > 30 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 11;
                break;
            case 12:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }else{
                    this.day = day;
                }
                this.month = 12;
                break;
            default:
                System.out.println("Your month is invalid!");  
                exit(0);
        }
    
    }
    
    public MyDate(String date){
        String[] tmp;
        tmp = date.split(" ");
        
        this.year = Integer.parseInt(tmp[2]);
        
        if(this.year <= 0){
            System.out.println("Your year is invalid");
            exit(0);
        }
        this.day = Integer.parseInt(tmp[1].replaceAll("[^0-9]", ""));
        
        switch(tmp[0].toLowerCase()){
            case "january":
                this.month = 1;
                if(this.day > 31 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                break;
            case "february":
                if(this.year % 100 == 0){
                    if(this.year % 400 == 0){
                        if(this.day > 29 || this.day <= 0){
                            System.out.println("Your day is invalid");
                            exit(0);
                        }
                    }else{
                        if(this.day > 28 || this.day <= 0){
                            System.out.println("Your day is invalid");
                            exit(0);
                        }
                    }
                }else if(this.year % 4 == 0){
                    if(this.day > 29 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                }else{
                    if(this.day > 28 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                }
                this.month = 2;
                break;
            case "march":
                if(this.day > 31 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 3;
                break;
            case "april":
                if(this.day > 30 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 4;
                break;
            case "may":
                if(this.day > 31 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 5;
                break;
            case "june":
                if(this.day > 30 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 6;
                break;
            case "july":
                if(this.day > 31 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 7;
                break;
            case "august":
                if(this.day > 31 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 8;
                break;
            case "september":
                if(this.day > 30 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 9;
                break;
            case "october":
                if(this.day > 31 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 10;
                break;
            case "november":
                if(this.day > 30 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 11;
                break;
            case "december":
                if(this.day > 31 || this.day <= 0){
                    System.out.println("Your day is invalid");
                    exit(0);
                }
                this.month = 12;
                break;
            default:
                System.out.println("Your month is invalid!");
                this.month = java.time.LocalDate.now().getMonthValue();                
        }

    }
    
    private int changeYear(String input){
        boolean isValidInput = true;
        int result = 0;
        int finalResult = 0;
        List<String> allowedStrings = Arrays.asList
        (
        "zero","one","two","three","four","five","six","seven",
        "eight","nine","ten","eleven","twelve","thirteen","fourteen",
        "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
        "thirty","forty","fifty","sixty","seventy","eighty","ninety",
        "hundred","thousand","million"
        );


        if(input != null && input.length()> 0)
        {
            input = input.replaceAll("-", " ");
            input = input.toLowerCase().replaceAll(" and", " ");
            String[] splittedParts = input.trim().split("\\s+");

            for(String str : splittedParts)
            {
                if(!allowedStrings.contains(str))
                {
                    isValidInput = false;
                    System.out.println("Invalid word found : "+str);
                    break;
                }
            }
            if(isValidInput)
            {
                for(String str : splittedParts)
                {
                    if(str.equalsIgnoreCase("zero")) {
                        result += 0;
                    }
                    else if(str.equalsIgnoreCase("one")) {
                        result += 1;
                    }
                    else if(str.equalsIgnoreCase("two")) {
                        result += 2;
                    }
                    else if(str.equalsIgnoreCase("three")) {
                        result += 3;
                    }
                    else if(str.equalsIgnoreCase("four")) {
                        result += 4;
                    }
                    else if(str.equalsIgnoreCase("five")) {
                        result += 5;
                    }
                    else if(str.equalsIgnoreCase("six")) {
                        result += 6;
                    }
                    else if(str.equalsIgnoreCase("seven")) {
                        result += 7;
                    }
                    else if(str.equalsIgnoreCase("eight")) {
                        result += 8;
                    }
                    else if(str.equalsIgnoreCase("nine")) {
                        result += 9;
                    }
                    else if(str.equalsIgnoreCase("ten")) {
                        result += 10;
                    }
                    else if(str.equalsIgnoreCase("eleven")) {
                        result += 11;
                    }
                    else if(str.equalsIgnoreCase("twelve")) {
                        result += 12;
                    }
                    else if(str.equalsIgnoreCase("thirteen")) {
                        result += 13;
                    }
                    else if(str.equalsIgnoreCase("fourteen")) {
                        result += 14;
                    }
                    else if(str.equalsIgnoreCase("fifteen")) {
                        result += 15;
                    }
                    else if(str.equalsIgnoreCase("sixteen")) {
                        result += 16;
                    }
                    else if(str.equalsIgnoreCase("seventeen")) {
                        result += 17;
                    }
                    else if(str.equalsIgnoreCase("eighteen")) {
                        result += 18;
                    }
                    else if(str.equalsIgnoreCase("nineteen")) {
                        result += 19;
                    }
                    else if(str.equalsIgnoreCase("twenty")) {
                        result += 20;
                    }
                    else if(str.equalsIgnoreCase("thirty")) {
                        result += 30;
                    }
                    else if(str.equalsIgnoreCase("forty")) {
                        result += 40;
                    }
                    else if(str.equalsIgnoreCase("fifty")) {
                        result += 50;
                    }
                    else if(str.equalsIgnoreCase("sixty")) {
                        result += 60;
                    }
                    else if(str.equalsIgnoreCase("seventy")) {
                        result += 70;
                    }
                    else if(str.equalsIgnoreCase("eighty")) {
                        result += 80;
                    }
                    else if(str.equalsIgnoreCase("ninety")) {
                        result += 90;
                    }
                    else if(str.equalsIgnoreCase("hundred")) {
                        result *= 100;
                    }
                    else if(str.equalsIgnoreCase("thousand")) {
                        result *= 1000;
                        finalResult += result;
                        result=0;
                    }
                    else if(str.equalsIgnoreCase("million")) {
                        result *= 1000000;
                        finalResult += result;
                        result=0;
                    }
                }

                finalResult += result;
            }
        }
        return finalResult;
    }
    
    public MyDate(String day, String month, String year){
        int d = 0, m = 0, y = 0;
        
        y = changeYear(year.toLowerCase());
        
        switch(day.toLowerCase()){
            case "first":
                d = 1;
                break;
            case "second":
                d = 2;
                break;
            case "third":
                d = 3;
                break;
            case "fourth":
                d = 4;
                break;
            case "fifth":
                d = 5;
                break;
            case "sixth":
                d = 6;
                break;
            case "seventh":
                d = 7;
                break;
            case "eighth":
                d = 8;
                break;
            case "ninth":
                d = 9;
                break;
            case "tenth":
                d = 10;
                break;
            case "eleventh":
                d = 11;
                break;
            case "twelfth":
                d = 12;
                break;
            case "thirteenth":
                d = 13;
                break;
            case "fourteenth":
                d = 14;
                break;
            case "fifteenth":
                d = 15;
                break;
            case "sixteenth":
                d = 16;
                break;
            case "seventeenth":
                d = 17;
                break;
            case "eighteenth":
                d = 18;
                break;
            case "nineteenth":
                d = 19;
                break;
            case "twentieth":
                d = 20;
                break;
            case "twenty first":
                d = 21;
                break;
            case "twenty second":
                d = 22;
                break;
            case "twenty third":
                d = 23;
                break;
            case "twenty fourth":
                d = 24;
                break;
            case "twenty fifth":
                d = 25;
                break;
            case "twenty sixth":
                d = 26;
                break;
            case "twenty seventh":
                d = 27;
                break;
            case "twenty eighth":
                d = 28;
                break;
            case "twenty ninth":
                d = 29;
                break;
            case "thirtieth":
                d = 30;
                break;
            case "thirty first":
                d = 31;
                break;
            default:
                System.out.println("Your day is invalid");
                d = 0;
        }

        switch(month.toLowerCase()){
            case "january":
                m = 1;
                
                break;
            case "february":
                m = 2;
                break;
            case "march":
                m = 3;
                break;
            case "april":
                m = 4;
                break;
            case "may":
                m = 5;
                break;
            case "june":
                m = 6;
                break;
            case "july":
                m = 7;
                break;
            case "august":
                m = 8;
                break;
            case "september":
                m = 9;
                break;
            case "october":
                m = 10;
                break;
            case "november":
                m = 11;
                break;
            case "december":
                m = 12;
                break;
            default:
                System.out.println("Your month is invalid!");
                m = 0;                
        }
        this.setYear(y);
        this.setMonth(m);
        this.setDay(d);
    }
    
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        switch(this.month){
            case 1:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 2:
                if(this.year % 100 == 0){
                    if(this.year % 400 == 0){
                        if(day > 29 || day <= 0){
                            System.out.println("Your day is invalid");                            
                        }else{
                            this.day = day;
                        }
                    }else{
                        if(day > 28 || day <= 0){
                            System.out.println("Your day is invalid");                           
                        }else{
                            this.day = day;
                        }
                    }
                }else if(this.year % 4 == 0){
                    if(day > 29 || day <= 0){
                        System.out.println("Your day is invalid");
                    }else{
                        this.day = day;
                    }
                }else{
                    if(day > 28 || day <= 0){
                        System.out.println("Your day is invalid");
                    }else{
                        this.day = day;
                    }
                }
                break;
            case 3:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 4:
                if(day > 30 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 5:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 6:
                if(day > 30 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 7:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 8:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 9:
                if(day > 30 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 10:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 11:
                if(day > 30 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            case 12:
                if(day > 31 || day <= 0){
                    System.out.println("Your day is invalid");
                }else{
                    this.day = day;
                }
                break;
            default:
                System.out.println("Your month is invalid!");              
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month > 0 && month <= 12){
            this.month = month;
        }else{
            System.out.println("Your month is invalid!");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year > 0){
            this.year = year;
        }else{
            System.out.println("Your year is invalid");
        }
    }
    
    public static boolean isNumeric(final String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }
    
    public void accept(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter day: ");
        String _day = sc.next();
        System.out.println("Enter month: ");
        String _month = sc.next();
        System.out.println("Enter year: ");
        String _year = sc.next();
        
        this.year = Integer.parseInt(_year);
        
        if(this.year <= 0){
            System.out.println("Your year is invalid");
            exit(0);
        }
        this.day = Integer.parseInt(_day.replaceAll("[^0-9]", ""));
        
        if(isNumeric(_month)){
            this.month = Integer.parseInt(_month);
            switch(this.month){
                case 1:
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 2:
                    if(this.year % 100 == 0){
                        if(this.year % 400 == 0){
                            if(this.day > 29 || this.day <= 0){
                                System.out.println("Your day is invalid");  
                                exit(0);
                            }
                        }else{
                            if(this.day > 28 || this.day <= 0){
                                System.out.println("Your day is invalid"); 
                                exit(0);
                            }
                        }
                    }else if(this.year % 4 == 0){
                        if(this.day > 29 || this.day <= 0){
                            System.out.println("Your day is invalid");
                            exit(0);
                        }
                    }else{
                        if(this.day > 28 || this.day <= 0){
                            System.out.println("Your day is invalid");
                            exit(0);
                        }
                    }
                    break;
                case 3:
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 4:
                    if(this.day > 30 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 5:
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 6:
                    if(this.day > 30 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 7:
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 8:
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 9:
                    if(this.day > 30 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 10:
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 11:
                    if(this.day > 30 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case 12:
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                default:
                    System.out.println("Your month is invalid!");   
                    exit(0);
            }
        }else{
            switch(_month.toLowerCase()){
                case "january":
                    this.month = 1;
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    break;
                case "february":
                    if(this.year % 100 == 0){
                        if(this.year % 400 == 0){
                            if(this.day > 29 || this.day <= 0){
                                System.out.println("Your day is invalid");
                                exit(0);
                            }
                        }else{
                            if(this.day > 28 || this.day <= 0){
                                System.out.println("Your day is invalid");
                                exit(0);
                            }
                        }
                    }else if(this.year % 4 == 0){
                        if(this.day > 29 || this.day <= 0){
                            System.out.println("Your day is invalid");
                            exit(0);
                        }
                    }else{
                        if(this.day > 28 || this.day <= 0){
                            System.out.println("Your day is invalid");
                            exit(0);
                        }
                    }
                    this.month = 2;
                    break;
                case "march":
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 3;
                    break;
                case "april":
                    if(this.day > 30 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 4;
                    break;
                case "may":
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 5;
                    break;
                case "june":
                    if(this.day > 30 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 6;
                    break;
                case "july":
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 7;
                    break;
                case "august":
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 8;
                    break;
                case "september":
                    if(this.day > 30 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 9;
                    break;
                case "october":
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 10;
                    break;
                case "november":
                    if(this.day > 30 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 11;
                    break;
                case "december":
                    if(this.day > 31 || this.day <= 0){
                        System.out.println("Your day is invalid");
                        exit(0);
                    }
                    this.month = 12;
                    break;
                default:
                    System.out.println("Your month is invalid!");
                    this.month = java.time.LocalDate.now().getMonthValue();                
            }

        }

    }
    
    public String date(){
        return this.day + "/" + this.month + "/" + this.year;
    }
    
    public void print(){
        System.out.println(date());
    }
    
    public void print_date_string(){
        String d = "" , m = "";
        switch(this.day){
            case 1:
                d = "1st";
                break;
            case 2:
                d = "2nd";
                break;
            case 3:
                d = "3rd";
                break;
            case 4:
                d = "4rd";
                break;
            case 5:
                d = "5rd";
                break;
            case 6:
                d = "6rd";
                break;
            case 7:
                d = "7rd";
                break;
            case 8:
                d = "8rd";
                break;
            case 9:
                d = "9rd";
                break;
            case 10:
                d = "10rd";
                break;
            case  11 :
                d = "11st";
                break;
            case  12 :
                d = "12nd";
                break;
            case  13 :
                d = "13rd";
                break;
            case  14 :
                d = "14rd";
                break;
            case  15 :
                d = "15rd";
                break;
            case  16 :
                d = "17rd";
                break;
            case  17 :
                d = "18rd";
                break;
            case  18 :
                d = "18rd";
                break;
            case  19 :
                d = "19rd";
                break;
            case  20 :
                d = "20rd";
                break;
            case  21 :
                d = "21st";
                break;
            case  22:
                d = "22nd";
                break;
            case  23:
                d = "23rd";
                break;
            case  24:
                d = "24rd";
                break;
            case  25:
                d = "25rd";
                break;
            case  26:
                d = "26rd";
                break;
            case  27:
                d = "27rd";
                break;
            case  28:
                d = "28rd";
                break;
            case  29:
                d = "29rd";
                break;
            case  30:
                d = "30rd";
                break;
            case  31:
                d = "31st";
                break;
        }

        switch(this.month){
            case 1:
                m = "January";
                break;
            case 2:
                m = "February";
                break;
            case 3:
                m = "March";
                break;
            case 4:
                m = "April";
                break;
            case 5:
                m = "May";
                break;
            case 6:
                m = "June";
                break;
            case 7:
                m = "July";
                break;
            case 8:
                m = "August";
                break;
            case 9:
                m = "September";
                break;
            case 10:
                m = "October";
                break;
            case 11:
                m = "November";
                break;
            case 12:
                m = "December";
                break;
                         
        }
        System.out.println(m+" "+d+" "+this.year);
    }
}
