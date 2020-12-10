package game;
import java.util.*;
import java.util.Scanner;
import java.util.Random;
public class Team {
	public static void main(String[] args) {
		int number_round=20;
		int number_battles=3;
		int team1_ptr=0;
		int team_ptr=0;
		int high=10000;
		int low=1;
		Random rand=new Random();
		ArrayList<Integer> lo_index= new ArrayList<Integer>(); 
		for (int i=0;i<number_battles;i++){
			int num=rand.nextInt((high-low)+low);
			lo_index.add(num);
			
		}
		int rockstrn1=lo_index.get(0);
		int paperstrn1=lo_index.get(0);
		int scissorstrn1=lo_index.get(0);
		
		int rockstrn2=lo_index.get(1);
		int paperstrn2=lo_index.get(1);
		int scissorstrn2=lo_index.get(1);
		
		
				
	}

}
