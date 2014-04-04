package net.hyrrmadr.cip7tocip13.test;

import net.hyrrmadr.cip7tocip13.CIP7toCIP13;

public class Main {

	public static void main(String[] args) {
		{
		  Object[] func = new Object[] {CIP7toCIP13.class, "CIP7ToCIP13"};
		  Object[][] arr = new Object[][] {
				  {"Aspirine upsa", "3358854", "3400933588540"},
				  {"Aspirine du rhone", "3342480", "3400933424800"},
				  {"Doliprane 500mg", "3307199", "3400933071998"},
		  };
		  Test.doMore(func, arr);
		}

		{
		  Object[] func = new Object[] {CIP7toCIP13.class, "checkCIP13"};
		  Object[][] arr = new Object[][] {
				  {"Aspirine upsa", "3400933588540", true},
				  {"Faux code", "4400933588540", false},
		  };
		  Test.doMore(func, arr);
		}
		System.out.println(Test.sumUp());
	}

}
