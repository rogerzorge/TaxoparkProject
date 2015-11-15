package com.epam.taxopark;

/**
 * Created by Yahor_Faliazhynski on 11/13/2015.
 */
public class Automobile extends Vehicle{

    private String carBrand;
    private int carCost;
    private float fuelConsumption;

    public Automobile() {
    }

    public Automobile(String carBrand, int carCost, float fuelConsumption) {
        this.carBrand = carBrand;
        this.carCost = carCost;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    protected void vehicleInfo() {
        System.out.println("Car brand: " + this.carBrand + "; Car cost: " + this.carCost + "; Fuel consumption: " + this.fuelConsumption);
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getCarCost() {
        return carCost;
    }

    public void setCarCost(int carCost) {
        this.carCost = carCost;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

}
