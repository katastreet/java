package test;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CaesarTest.class);	
		for (Failure failure : result.getFailures()) {
			         System.out.println(failure.toString());
		}
					
		System.out.println("Success status for caser encrypt encrypt class:" + result.wasSuccessful());
		
		//break the cipher example
		Caesar caesarhack = new Caesar();
		System.out.println(caesarhack.breakcypher("jvvr://yyy.iqqing.eqo"));
		
		Cipher v = new Vigenere();
		System.out.println(v.encrypt("TOBEO RNOTT OBE","RELAT IONSR ELA"));
		System.out.println(v.decrypt("KSMEH ZBBLK SME","RELAT IONSR ELA"));
		
	}

}
