package net.hyrrmadr.cip7tocip13.test;

import java.lang.reflect.Method;

public class Test {
	private static int tests = 1;
	private static int errors = 0;
	
	public static boolean doTest(Object[] func, Object[] args) {
		try {
		if (func.length < 2)
			throw new IllegalArgumentException("func array MUST contains the object or class and the method to call");
		else if (args.length < 3)
			throw new IllegalArgumentException("args array MUST contains the label, arguments and return value for the test");
		
		 System.out.println(String.format("Test %04d : %s", new Object[] {tests, args[0]}));

		 Class<?> clazz;
		 Object obj;
		 if (func[0] instanceof Class) {
			 obj = null;
			 clazz = (Class<?>) func[0];
		 } else {
			 obj = func[0];
			 clazz = obj.getClass();
		 }
		 String mname = func[1].toString();
		 String name = clazz.getName() + "." + mname;
		 Method method = clazz.getMethod(mname, String.class);
		 
		 Object ret = method.invoke(obj, args[1]);
		 System.out.println(String.format("Calling  : %s(%s)", new Object[] { name, args[1] }));
		 System.out.println(String.format("Returns  : %s", new Object[] { ret }));
		 System.out.println(String.format("Expected : %s", new Object[] { args[2] }));
		 
		 boolean passed = true;
		 
		 try {
			 System.out.print("Result   : ");
		     assert(args[2].equals(ret));
			 System.out.println("Passed");
		 } catch (AssertionError e) {
			 System.out.println("Failed");
			 ++errors;
			 passed = false;
		 }
		 System.out.println();
		 ++tests;
		 return passed;
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Cannot call given function: " + e.getMessage());
		}
	}

	public static void doMore(Object[] func, Object[][] aargs) {
		for (Object[] args : aargs) {
			doTest(func, args);
		}
	}
	
	public static int countTests() {
		return tests - 1;
	}
	
	public static int countErrors() {
		return errors;
	}
	
	public static boolean isOk() {
		return errors == 0;
	}
	
	public static String sumUp() {
		return String.format("Tests: %d; Errors: %d; Result: %s",
					new Object[] { 	new Integer(countTests()),
									new Integer(countErrors()),
									isOk() ? "OK" : "KO"
					}
				);
	}
}
