package test;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class HelloWorld {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(junittest.class);	
		for (Failure failure : result.getFailures()) {
			         System.out.println(failure.toString());
		}
					
		System.out.println("Success status for caser encrypt encrypt class:" + result.wasSuccessful());
		
		//break the cipher example
		ceaser s = new ceaser();
		System.out.println(s.breakcypher("jvvr://yyy.iqqing.eqo"));
		
		vigenere v = new vigenere("RELAT IONSR ELA");
		System.out.println(v.encrypt("TOBEO RNOTT OBE"));
		System.out.println(v.decrypt("KSMEH ZBBLK SME"));
		
	}

}
