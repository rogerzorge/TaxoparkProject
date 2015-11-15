package com.epam.taxopark;

/**
 * Created by Yahor_Faliazhynski on 11/13/2015.
 */
public abstract class Vehicle {

        protected void engineStarts() {
            System.out.println(" engine was started");
        }
        protected void ride() {
            System.out.println(" is riding to a destination point");
        }
        protected abstract void vehicleInfo();

    }