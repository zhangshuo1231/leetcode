package com.company;

// 7.3f

public class InsuranceValues {
    public static void main(String[] args) {
        System.out.println("Final: " + totalValue(10.0f, 12,23000, 15, 10));
    }

    public static int totalValue(float annualizedRatePct, int numTimesCompoundedPerYear,int yearlyContribution, int numYearsContribution, int numYearsAfterContribution) {
        double curr = yearlyContribution;
        System.out.println("Year " + 0 + ", current value: " + (int) curr);
        for (int cnt = 1; cnt <= numYearsContribution; cnt++) {
            curr = calculate(curr, 1, annualizedRatePct, numTimesCompoundedPerYear);
            if (cnt != numYearsContribution) {
                curr += yearlyContribution;
            }
            System.out.println("Year " + cnt + ", current value: " + (int) curr);
        }
        for (int cnt = 1; cnt <= numYearsAfterContribution; cnt++) {
            curr = calculate(curr, 1, annualizedRatePct, numTimesCompoundedPerYear);
            System.out.println("Year " + (numYearsContribution + cnt) + ", current value: " + (int) curr);
        }
        return (int) curr;
    }

    private static double calculate(double primary, int numYears, double annualizedRatePct, int numTimesCompoundedPerYear) {
        return primary * Math.pow(1 + (annualizedRatePct / 100.0 / numTimesCompoundedPerYear), numTimesCompoundedPerYear * numYears);
    }
}
