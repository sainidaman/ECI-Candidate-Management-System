package com.ecimanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecimanagement.dao.Candidatedao;
import com.ecimanagement.entity.Candidate;

public class CandidateService {
	Candidatedao cdao=null;
	List<Candidate> allCandidate=new ArrayList<Candidate>();
	
	public List<Candidate> displayAllCandidates() throws ClassNotFoundException
	{
		cdao=new Candidatedao();
		return cdao.displayAllCandidates();
		
	}
	
	public List<Candidate> getCandidatesPartyWise(String party_name) throws ClassNotFoundException
	{
		cdao=new Candidatedao();
		ArrayList<Candidate> partyCandidates=new ArrayList<Candidate>();
		allCandidate= cdao.displayAllCandidates();
		for(Candidate all:allCandidate)
		{
			if(all.getParty_name().equalsIgnoreCase(party_name))
			{
				partyCandidates.add(all);
			}
		}
		return partyCandidates;
	}

	public Map<String,List<Candidate>> getCandidates_RegionWise() throws ClassNotFoundException {		
		cdao=new Candidatedao();		
		allCandidate= cdao.displayAllCandidates();
		Map<String,List<Candidate>> regionwise_Candidates=new HashMap<String ,List<Candidate>>();
		for(Candidate all:allCandidate)
		{
			regionwise_Candidates.computeIfAbsent(all.getState(), k -> new ArrayList<>()).add(all);
		}
		return regionwise_Candidates;
	}
	public Map<String,List<Candidate>> getCandidates_AssemblyWise() throws ClassNotFoundException {
		cdao=new Candidatedao();		
		allCandidate= cdao.displayAllCandidates();
		Map<String,List<Candidate>> assemblywise_Candidates=new HashMap<String ,List<Candidate>>();
		for(Candidate all:allCandidate)
		{
		assemblywise_Candidates.computeIfAbsent(all.getConstituency(), k -> new ArrayList<>()).add(all);
		}
		return assemblywise_Candidates;
	}

	public Map<String, List<Candidate>> getCandidates_AllMale() throws ClassNotFoundException {
		cdao=new Candidatedao();		
		allCandidate= cdao.displayAllCandidates();
		Map<String,List<Candidate>> allMale_Candidates=new HashMap<String ,List<Candidate>>();
		for(Candidate candidate:allCandidate)
		{
			if(candidate.getGender().equalsIgnoreCase("Male"))
			{
			allMale_Candidates.computeIfAbsent(candidate.getConstituency(), k -> new ArrayList<>()).add(candidate);
			}
		}
		return allMale_Candidates;
	}

	public Map<String, List<Candidate>> getCandidates_AllFemale() throws ClassNotFoundException {
		cdao=new Candidatedao();		
		allCandidate= cdao.displayAllCandidates();
		Map<String,List<Candidate>> allFeMale_Candidates=new HashMap<String ,List<Candidate>>();
		for(Candidate all:allCandidate)
		{
			if(all.getGender().equalsIgnoreCase("Female"))
			{
				allFeMale_Candidates.computeIfAbsent(all.getConstituency(), k -> new ArrayList<>()).add(all);
			}
		}
		return allFeMale_Candidates;
	}

	public String insertCandidate(String cname,String pname,String constituency,String gender,String state, int age) {
		int result= new Candidatedao().insertCandidate(cname,pname,constituency,gender,state,age);
		String message=null;
		if(result>0)
		{
			message="Record inserted successfully";
		}
		else
		{
			message="No data inserted";
		}
		return message;
	}

	public String updateCandidate(String cname,String pname,String constituency,String gender,String state, int age,int cid) {
		boolean updatedrows=new Candidatedao().updateCandidate(cname,pname,constituency,gender,state,age,cid);
		String message=null;
		if(updatedrows)
		{
			message="Record updated successfully";
		}
		else
		{
			message="No record updated/found";
		}
		return message;
		
	}

	public String deleteCandidate(int cid) {
		String message=null;
		boolean updatedrow=new Candidatedao().deleteCandidate(cid);
		if(updatedrow)
		{
			message="Record updated successfully";
		}
		else
		{
			message="No record deleted/found";
		}
		return message;
		
	}

	

	

}
