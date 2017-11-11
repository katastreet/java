package test.commitment;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import javax.xml.crypto.dsig.SignedInfo;

public class ElGamalCommitment {
	public static int n;
	public int g;
	public int h;
	
	public ElGamalCommitment(int g, int h) {
		this.g = g;
		this.h = h;

	}
	
	public static int  generateG() {
		//use prime generator for now 13
		int g=13;
		return g;	
	}
	
	public static int generateH(int g) {
		SecureRandom test = new SecureRandom();
		
		//private key generation
		int result = test.nextInt(1000000);
		
		int output = BigInteger.valueOf(g).pow(result).mod(BigInteger.valueOf(n)).intValue();
		
		return output;
	}
	
	public BigInteger generateCommit(int u, int x) {
		BigInteger output1 = BigInteger.valueOf(g).pow(u);
		BigInteger output2 = BigInteger.valueOf(h).pow(u+x);
		return output1.add(output2);
	}
	
	public Boolean verifyCommit(int u, int x, BigInteger commit) {
		BigInteger verifyingCommit = generateCommit(u, x);
		if(verifyingCommit.equals(commit)) {
			return true;
		}
		return false;	
	}

}
