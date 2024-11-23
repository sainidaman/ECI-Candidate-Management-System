package com.ecimanagement.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.ecimanagement.controller.CandidatesController;
import com.ecimanagement.entity.Candidate;

public class ElectionCommisionClient {

	public static void main(String[] args) throws ClassNotFoundException {
		
			System.out.println();
			System.out.println("**********WELCOME TO ELECTION COMISSION OF INDIA***********");
			System.out.println();
			System.out.println();
			int choice=-1;
			Scanner sc=new Scanner(System.in);
			Scanner sc1=new Scanner(System.in);
			
			do {
				
				System.out.println();
				System.out.println("-Candidate Affidavit Management-");
				System.out.println();
			System.out.println("1. Display all Candidates details.");
			System.out.println("2. Search Candidates by Party_Name.");
			System.out.println("3. Display all Candidates Region wise.");
			System.out.println("4. Display all Candidates Assembly wise.");
			System.out.println("5. Display all Male Candidates Assembly wise.");
			System.out.println("6. Display all Female Candidates Assembly wise");
			System.out.println("7. Insert new Candidate");
			System.out.println("8. Update an existing Candidate");
			System.out.println("9. Delete a Candidate");
			System.out.println("0. Exit");
			System.out.println("----------------------------------------------------------------------------------------------");
			System.out.println("Select your option......");
			try
			{
			choice=sc.nextInt();	
			
			switch(choice)
			{
			case 1:
				List<Candidate> all_candiates=new CandidatesController().getAllCandidates();
				System.out.println("-----------------------------------------------------------------------------------------");
				for(Candidate c:all_candiates)
				{
					System.out.println(c.getCid()+" | "+c.getC_name()+" | "+c.getParty_name()+" | "+c.getConstituency()+" | "+c.getGender()+" | "+c.getState()+" | " +c.getAge());
					System.out.println("-----------------------------------------------------------------------------------------");
				}
				
				break;
			case 2:
				System.out.println("Enter the name of the assembly: ");
				String party_name=sc1.nextLine();
				List<Candidate> party_candiates=new CandidatesController().getCandidatesPartyWise(party_name);
				System.out.println("-----------------------------------------------------------------------------------------");
				for(Candidate c:party_candiates)
				{
					System.out.println(c.getC_name()+" | "+c.getParty_name()+" | "+c.getConstituency()+" | "+c.getGender()+" | "+c.getState()+" | " +c.getAge());
					System.out.println("-----------------------------------------------------------------------------------------");
				}
				break;
			case 3:			
				Map<String,List<Candidate>> display_RegionWise=new CandidatesController().getAllCandidatesRegionWise();
				for (Map.Entry<String, List<Candidate>> entry:display_RegionWise.entrySet())
				{
					System.out.println("-----------------------------------------------------");
					System.out.println("Region: "+ entry.getKey());
					System.out.println("-----------------------------------------------------");
					System.out.println();
				System.out.println("List of all Candidates under "+entry.getKey()+":");
				System.out.println();
				for(Candidate c :entry.getValue())
				{
					System.out.println(c.getC_name()+" | "+c.getParty_name()+" | "+c.getConstituency()+" | "+c.getGender()+" | "+c.getState()+" | " +c.getAge());
					}
			}
			
			break;
			case 4:
				Map<String, List<Candidate>> display_AssemblyWise=new CandidatesController().getCandidates_AssemblyWise();
				for (Entry<String, List<Candidate>> entry:display_AssemblyWise.entrySet())
				{
					System.out.println("-----------------------------------------------------");
					System.out.println("Assembly: "+ entry.getKey());
					System.out.println("-----------------------------------------------------");
					System.out.println();
				System.out.println("List of all Candidates under "+entry.getKey()+":");
				System.out.println();
				for(Candidate c :entry.getValue())
				{
					System.out.println(c.getC_name()+" | "+c.getParty_name()+" | "+c.getConstituency()+" | "+c.getGender()+" | "+c.getState()+" | " +c.getAge());
					}
			}
				break;
			case 5:
				Map<String, List<Candidate>> allmale_candidate=new CandidatesController().getCandidates_AllMale();
				for (Entry<String, List<Candidate>> entry:allmale_candidate.entrySet())
				{
					System.out.println("-----------------------------------------------------");
					System.out.println("Assembly: "+ entry.getKey());
					System.out.println("-----------------------------------------------------");
					System.out.println();
				System.out.println("List of all Male Candidates under "+entry.getKey()+":");
				System.out.println();
				for(Candidate c :entry.getValue())
				{
					System.out.println(c.getC_name()+" | "+c.getParty_name()+" | "+c.getConstituency()+" | "+c.getGender()+" | "+c.getState()+" | " +c.getAge());
					}
			}
				break;
			case 6:
				Map<String, List<Candidate>> allfemale_candidate=new CandidatesController().getCandidates_AllFemale();
				for (Entry<String, List<Candidate>> entry:allfemale_candidate.entrySet())
				{
					System.out.println("-----------------------------------------------------");
					System.out.println("Assembly: "+ entry.getKey());
					System.out.println("-----------------------------------------------------");
					System.out.println();
				System.out.println("List of all Female Candidates under "+entry.getKey()+":");
				System.out.println();
				for(Candidate c :entry.getValue())
				{
					System.out.println(c.getC_name()+" | "+c.getParty_name()+" | "+c.getConstituency()+" | "+c.getGender()+" | "+c.getState()+" | " +c.getAge());
					}
			}
				break;
			case 7:
				System.out.println("Add details of the new Candidate");
				System.out.println("Candidate Name: ");
				String cname=sc1.nextLine();
				System.out.println("Candidate Party: ");
				String pname=sc1.nextLine();
				System.out.println("Candidate constituency: ");
				String constituency=sc1.nextLine();
				System.out.println("Candidate gender: ");
				String gender=sc1.nextLine();
				System.out.println("Candidate state: ");
				String state=sc1.nextLine();
				System.out.println("Candidate age: ");
				int age=sc.nextInt();
				String result=new CandidatesController().insertCandidate(cname,pname,constituency,gender,state,age);
				System.out.println(result);
				break;
			case 8:
				System.out.println("Enter customer id for update");
				int id=sc.nextInt();
				System.out.println("Add details of the new Candidate");
				System.out.println("Candidate Name: ");
				String cname1=sc1.nextLine();
				System.out.println("Candidate Party: ");
				String pname1=sc1.nextLine();
				System.out.println("Candidate constituency: ");
				String constituency1=sc1.nextLine();
				System.out.println("Candidate gender: ");
				String gender1=sc1.nextLine();
				System.out.println("Candidate state: ");
				String state1=sc1.nextLine();
				System.out.println("Candidate age: ");
				int age1=sc.nextInt();
				String msg=new CandidatesController().updateCandidate(cname1,pname1,constituency1,gender1,state1,age1,id);
				System.out.println(msg);
				break;
			case 9:
				System.out.println("Enter customer id for the customer to delete");
				int cid=sc.nextInt();
				String message=new CandidatesController().deleteCandidate(cid);
				System.out.println(message);
				break;
			case 0:
				System.out.println("Thank you!!Visit again!!");
				break;
				default:
					System.out.println("Enter valid input");
			}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter valid input");
				sc.nextLine();
			}
			}while(choice!=0);
			sc.close();
			sc1.close();
		}

}


