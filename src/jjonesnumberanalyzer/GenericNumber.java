/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjonesnumberanalyzer;

/**
 *
 * @author Jacob Jones
 * @param <T> - The generic type. Will only accept types that are subclasses of Number.
 * 
 */
public class GenericNumber<T extends Number> {
    private final T numbers[];
    
    /**
     * The constructor for the class
     * @param num[] - The array to assign to the numbers array
     */
    GenericNumber(T num[]){
        numbers = num;
    }
    
    /**
     * This method will return the highest number from the list
     * @return highest - The highest number in the list
     */
    public T getHighest(){
        
        // The highest number in the list
        T highest = numbers[0];
        
        // Checks if there are multiple numbers in the list
        if(numbers.length > 1){
            // Checks each number in the list
            for(T number : numbers){
                // Checks if the current number is larger than the current highest number
                // If so, then make the current number the highest number
                if(number.doubleValue() > highest.doubleValue()){
                    highest = number;
                }
            }
        }
        
        return highest;
    }
    
    /**
     * This method will return the lowest number in the list
     * @return lowest - The lowest number in the list
     */
    public T getLowest(){
        // The lowest number
        T lowest = numbers[0];
        
        // Checks if there are multiple numbers in the list
        if(numbers.length > 1){
            // Checks each number in the list
            for(T number : numbers){
                // Checks if the current number is lower than the current lowest number
                // If so, then make the current number the lowest number
                if(number.doubleValue() < lowest.doubleValue()){
                    lowest = number;
                }
            }
        }
        
        return lowest;
    }
    
    /**
     * This method will return the sum of all the numbers in the list
     * @return sum - The sum of the list
     */
    public Double getSum(){
        // The sum of the list
        Double sum = new Double(0);
        
        // Checks if there are multiple numbers in the list
        if(numbers.length > 1){
            // Adds each number in the list to the sum
            for(Number number : numbers){
                sum += number.doubleValue();
            }
        }
        
        return sum;
    }
    
    /**
     * This method will return the average of the numbers in the list
     * @return average - The average of the list
     */
    public Double getAverage(){
        // The average of the list
        // Divides the sum of the list by the amount of numbers in the list
        Double average = getSum() / numbers.length;
        return average;
    }
}
