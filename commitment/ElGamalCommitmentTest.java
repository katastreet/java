package test.commitment;

import java.math.BigInteger;
import java.security.SecureRandom;


public class ElGamalCommitmentTest {
	public static void main(String[] args) {
	ElGamalCommitment.n = 1024;
	int g = ElGamalCommitment.generateG();
	int h = ElGamalCommitment.generateH(g);
	
	
	
	int x = 0;
	
	SecureRandom test = new SecureRandom();
	int u = test.nextInt(ElGamalCommitment.n);
	

	ElGamalCommitment sender = new ElGamalCommitment(g, h);
	
	
	BigInteger senderCommit = sender.generateCommit(u,x);
	
	//sender sent the commit
	
	//reciever generated key
	int y = 0;
	
	//receiver reveal phase
	x = 0;
	ElGamalCommitment reciever = new ElGamalCommitment(g, h);
	System.out.println("commit verified:" + reciever.verifyCommit(u,x,senderCommit));
	
	
	System.out.println("if sender alters data.......");
	//if sender tries to alter
	x=1;
	ElGamalCommitment reciever2 = new ElGamalCommitment(g, h);
	System.out.println("commit verified:" + reciever2.verifyCommit(u,x,senderCommit));
	
}
}
