package com.epam.taxopark;

import java.util.*;
import java.*;

/**
 * Created by Yahor_Faliazhynski on 11/13/2015.
 */
public class TaxoparkRunner {

    static String answerKey;
    static int lowRangeValueCarCost;
    static int highRangeValueCarCost;
    static int lowRangeValueFuelConsumption;
    static int highRangeValueFuelConsumption;

    public static void main(String[] args) {

        int randomCarIndex;
        int taxoparkCost = 0;
        int listSize = 0;

        List<Automobile> list = new ArrayList<Automobile>();
        list.add(new Automobile("Fiat 500", 8500, 5.5f));
        list.add(new Automobile("Ford Fiesta", 11400, 5.8f));
        list.add(new Automobile("Renault Clio", 10600, 5.7f));
        list.add(new Automobile("Audi A1", 14600, 5.4f));
        list.add(new Automobile("VW Golf", 14500, 5.9f));
        list.add(new Automobile("Peugeot 308", 13900, 6.0f));
        list.add(new Automobile("Alfa Romeo Giulietta", 14900, 6.2f));
        list.add(new Automobile("Toyota Auris", 15300, 6.3f));
        list.add(new Automobile("Mercedes A Class", 21000, 7.4f));
        list.add(new Automobile("Citroen C4 Picasso", 16350, 8.6f));
        list.add(new Automobile("VW Touran", 18700, 9.1f));
        list.add(new Automobile("Scoda Yeti", 18300, 5.6f));
        list.add(new Automobile("Citroen C4 Picasso", 16200, 8.6f));
        list.add(new Automobile("Opel Zafira", 19200, 9.7f));
        list.add(new Automobile("Volvo S80", 29300, 8.9f));
        list.add(new Automobile("Jaguar XF", 43150, 12.7f));
        list.add(new Automobile("Mercedes Vito", 39990, 13.1f));
        list.add(new Automobile("Seat Alhambra", 27950, 12.3f));
        list.add(new Automobile("Mercedes S Class Estate", 68900, 14.9f));

        list.get(0).setCarCost(8600);
        list.get(1).setFuelConsumption(5.85f);
        list.get(4).setCarBrand("VW Golf 6");

        System.out.println("Taxopark before sorting:");
        //Output through iterator
        Iterator<Automobile> it = list.iterator();
        while (it.hasNext()) {
            it.next().vehicleInfo();
        }

        System.out.println();

        Collections.sort(list, new CarBrandComparator());
        System.out.println("Taxopark after sorting by CAR BRAND:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ") " + list.get(i).getCarBrand() + "\t" + list.get(i).getCarCost() + "\t" + list.get(i).getFuelConsumption());
        }

        System.out.println();

        Collections.sort(list, new CarCostComparator());
        System.out.println("Taxopark after sorting by CAR COST:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ") " + list.get(i).getCarBrand() + "\t" + list.get(i).getCarCost() + "\t" + list.get(i).getFuelConsumption());
        }

        System.out.println();

        Collections.sort(list, new FuelConsumptionComparator());
        System.out.println("Taxopark after sorting by FUEL CONSUMPTION:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ") " + list.get(i).getCarBrand() + "\t" + list.get(i).getCarCost() + "\t" + list.get(i).getFuelConsumption());
        }

        System.out.println();

        //Choosing a random car from list collection sorted by fuel consumption
        randomCarIndex = (int)(Math.random() * (list.size()));
        System.out.println("I have chosen a car by [" + randomCarIndex + "] index - " + list.get(randomCarIndex).getCarBrand());
        System.out.print(list.get(randomCarIndex).getCarBrand());
        list.get(randomCarIndex).engineStarts();
        System.out.print(list.get(randomCarIndex).getCarBrand());
        list.get(randomCarIndex).ride();

        System.out.println();

        //Calculation of taxopark cost
        for (int i = 0; i < list.size(); i++) {
            taxoparkCost += list.get(i).getCarCost();
        }
        System.out.println("Taxopark cost: " + taxoparkCost);

        System.out.println();

        //Enter a definite ranges of car cost and fuel consumption
        filterRangeReaderFunc();

        System.out.println();

        //Filter definite cars by car cost
        List<Automobile> filteredList = new ArrayList<Automobile>();
        System.out.println("Specified car cost range is [" + lowRangeValueCarCost + "; " + highRangeValueCarCost + "]");
        System.out.println("Specified fuel consumption range is [" + lowRangeValueFuelConsumption + "; " + highRangeValueFuelConsumption + "]");

        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getCarCost() >= lowRangeValueCarCost) && (list.get(i).getCarCost() <= highRangeValueCarCost)) {
                filteredList.add(list.get(i));
            }
        }

        System.out.println();

        //Show cars list filtered by car cost
        if (filteredList.size() != 0) {
            System.out.println("The list of cars filtered by car cost:");
            Iterator<Automobile> it2 = filteredList.iterator();
            while (it2.hasNext()) {
                it2.next().vehicleInfo();
            }
        }

        listSize = filteredList.size();

        //Filter definite cars by fuel consumption
        if (listSize == 0) {
            System.out.println("No car in taxopark from specified car cost range");
        }else {
            for (int i = (listSize - 1); i >= 0; i--) {
                if ((filteredList.get(i).getFuelConsumption() < lowRangeValueFuelConsumption) || (filteredList.get(i).getFuelConsumption() > highRangeValueFuelConsumption)) {
                    filteredList.remove(i);
                }
            }
        }

        System.out.println();

        //Show final cars list filtered by car cost and fuel consumption
        if (filteredList.size() == 0){
            System.out.println("No car in taxopark from specified fuel consumption range");
        } else {

            System.out.println("The list of cars filtered by car cost and fuel consumption:");
            Iterator<Automobile> it3 = filteredList.iterator();
            while (it3.hasNext()) {
                it3.next().vehicleInfo();
            }
        }
    }

    // Static method for reading ranges of car cost and fuel consumption
    static void filterRangeReaderFunc () {

        Scanner scn = new Scanner(System.in);

        System.out.println("Do you want to use filter (Answer Y or y for filter specifying on the next step): ");
        answerKey = scn.next().trim();

        if (answerKey.equals("Y") || answerKey.equals("y")) {
            System.out.println("Enter the low range value of car cost (integer): ");
            lowRangeValueCarCost = scn.nextInt();

            System.out.println("Enter the high range value of car cost (integer): ");
            highRangeValueCarCost = scn.nextInt();

            System.out.println("Enter the low range value of fuel consumption (integer): ");
            lowRangeValueFuelConsumption = scn.nextInt();

            System.out.println("Enter the high range value of fuel consumption (integer): ");
            highRangeValueFuelConsumption = scn.nextInt();
        } else System.out.println("No filter used!");
    }

}
