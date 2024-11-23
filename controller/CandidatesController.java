package com.ecimanagement.controller;

import java.util.List;
import java.util.Map;

import com.ecimanagement.entity.Candidate;
import com.ecimanagement.service.CandidateService;

public class CandidatesController {

	//CandidateService serv=null;
	public List<Candidate> getAllCandidates() throws ClassNotFoundException {
		 return new CandidateService().displayAllCandidates();
		 
	}
	public List<Candidate> getCandidatesPartyWise(String party_name) throws ClassNotFoundException
	{
		 return new CandidateService().getCandidatesPartyWise(party_name);
	}
	public Map<String,List<Candidate>> getAllCandidatesRegionWise() throws ClassNotFoundException {
		return new CandidateService().getCandidates_RegionWise();
	}
	public Map<String,List<Candidate>> getCandidates_AssemblyWise() throws ClassNotFoundException {
		return new CandidateService().getCandidates_AssemblyWise();
	}
	public Map<String, List<Candidate>> getCandidates_AllMale() throws ClassNotFoundException {
		return new CandidateService().getCandidates_AllMale();
	}
	public Map<String, List<Candidate>> getCandidates_AllFemale() throws ClassNotFoundException {
		 return new CandidateService().getCandidates_AllFemale();
	}
	public String insertCandidate(String cname,String pname,String constituency,String gender,String state, int age) {
		return new CandidateService().insertCandidate(cname,pname,constituency,gender,state,age);
		
	}
	public String updateCandidate(String cname,String pname,String constituency,String gender,String state, int age,int cid) {
		return new CandidateService().updateCandidate(cname,pname,constituency,gender,state,age,cid);
		
	}
	public String deleteCandidate(int cid) {
		return new CandidateService().deleteCandidate(cid);
		 
	}

}
