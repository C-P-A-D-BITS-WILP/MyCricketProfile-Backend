package com.bits.cpad.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.dto.BattingScoreDTO;
import com.bits.cpad.dto.BowlingScoreDTO;
import com.bits.cpad.dto.InningsDTO;
import com.bits.cpad.dto.MatchScoreCardDTO;
import com.bits.cpad.entity.BattingScore;
import com.bits.cpad.entity.BowlingScore;
import com.bits.cpad.entity.CricketMatch;
import com.bits.cpad.entity.Dismissal;
import com.bits.cpad.entity.InningsScore;
import com.bits.cpad.entity.ScoreCard;
import com.bits.cpad.entity.Team;
import com.bits.cpad.entity.Tournament;
import com.bits.cpad.entity.User;
import com.bits.cpad.repository.InningsRepository;
import com.bits.cpad.repository.MatchRepository;
import com.bits.cpad.repository.TeamRepository;
import com.bits.cpad.repository.TournamentRepository;
import com.bits.cpad.repository.UserRepository;

@RestController
public class TestController {

	@Autowired
	MatchRepository matchrepo;
	@Autowired
	TeamRepository teamRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	TournamentRepository tourRepo;
	
	@Autowired InningsRepository inningsRepo;

	@GetMapping(path = "/addMatchData1")
	public String addScores() {
		CricketMatch match = new CricketMatch();
		match.setTeam1(getTeamRCBDB());
		match.setTeam2(getTeamGTDB());
		match.setMatchDate(new Date(122, 4, 30));
		match.setMatchType("T20");
		match.setMom(getTewatiaDB());
		match.setWinningTeam(getTeamGTDB());
		match.setTournament(getIPLDB());

		ScoreCard sc = new ScoreCard();
		sc.setInnings1(getRCBInnings1());
		sc.setInnings2(getGTInnings2());

		match.setScoreCard(sc);

		matchrepo.save(match);

		return "success";
	}

	@GetMapping(path = "/addScores")
	private String addBattingAndBowling() {
		InningsScore innings = inningsRepo.findById(104).get();
		innings.setBattingScore(getRCBBattingScores());
		innings.setBowlingScore(getGTBowlingScores());
		
		inningsRepo.save(innings);

		InningsScore innings2 = inningsRepo.findById(104).get();
		innings2.setBattingScore(getGTBattingScores());
		innings2.setBowlingScore(getRCBBowlingScores());
		
		inningsRepo.save(innings2);
		
		return "success";
	}
	
	private InningsScore getRCBInnings1() {
		InningsScore innings = new InningsScore();
		innings.setBattingTeam(getTeamRCBDB());
		innings.setBowlingTeam(getTeamGTDB());
		innings.setOvers(20.0);
		innings.setTotalScore(170);
		innings.setWickets(6);
		innings.setBattingScore(getRCBBattingScores());
		innings.setBowlingScore(getGTBowlingScores());

		return innings;
	}
	
	private InningsScore getGTInnings2() {
		InningsScore innings = new InningsScore();
		innings.setBowlingTeam(getTeamRCBDB());
		innings.setBattingTeam(getTeamGTDB());
		innings.setOvers(19.3);
		innings.setTotalScore(174);
		innings.setWickets(4);
		innings.setBattingScore(getGTBattingScores());
		innings.setBowlingScore(getRCBBowlingScores());

		return innings;
	}

	private List<BowlingScore> getRCBBowlingScores() {
		List<BowlingScore> bowlingScores = new ArrayList<BowlingScore>();

		// maxwell
		BowlingScore bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(14));
		bowlingScore.setOvers(1.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(10);
		bowlingScore.setWickets(0);
		bowlingScores.add(bowlingScore);

		// siraj
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(20));
		bowlingScore.setOvers(4.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(35);
		bowlingScore.setWickets(0);
		bowlingScores.add(bowlingScore);

		// Hazlewood
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(21));
		bowlingScore.setOvers(3.3);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(36);
		bowlingScore.setWickets(0);
		bowlingScores.add(bowlingScore);

		// Shahbaz
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(16));
		bowlingScore.setOvers(3.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(26);
		bowlingScore.setWickets(2);
		bowlingScores.add(bowlingScore);

		// hashal
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(19));
		bowlingScore.setOvers(4.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(35);
		bowlingScore.setWickets(0);
		bowlingScores.add(bowlingScore);

		// hasaranga
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(18));
		bowlingScore.setOvers(4.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(28);
		bowlingScore.setWickets(2);
		bowlingScores.add(bowlingScore);

		return bowlingScores;
	}

	private List<BattingScore> getGTBattingScores() {
		List<BattingScore> battingScores = new ArrayList<BattingScore>();

		// saha
		BattingScore battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(54));
		battingScore.setRuns(29);
		battingScore.setBalls(22);
		battingScore.setFours(4);
		battingScore.setSixers(0);

		Dismissal dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(18));
		dismissal.setFielder(getPlayerDB(13));
		dismissal.setDismissalType("Caught");
		battingScore.setDismissal(dismissal);

		battingScores.add(battingScore);

		// gill
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(55));
		battingScore.setRuns(31);
		battingScore.setBalls(28);
		battingScore.setFours(3);
		battingScore.setSixers(1);

		dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(16));
		dismissal.setDismissalType("lbw");
		battingScore.setDismissal(dismissal);

		battingScores.add(battingScore);

		// sai
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(63));
		battingScore.setRuns(20);
		battingScore.setBalls(14);
		battingScore.setFours(2);
		battingScore.setSixers(0);

		dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(18));
		dismissal.setDismissalType("Bowled");
		battingScore.setDismissal(dismissal);

		battingScores.add(battingScore);

		// hardik
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(53));
		battingScore.setRuns(3);
		battingScore.setBalls(5);
		battingScore.setFours(0);
		battingScore.setSixers(0);

		dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(16));
		dismissal.setFielder(getPlayerDB(17));
		dismissal.setDismissalType("Caught");
		battingScore.setDismissal(dismissal);

		battingScores.add(battingScore);

		// david
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(56));
		battingScore.setRuns(39);
		battingScore.setBalls(24);
		battingScore.setFours(4);
		battingScore.setSixers(1);
		battingScores.add(battingScore);

		// Rahul
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(57));
		battingScore.setRuns(43);
		battingScore.setBalls(25);
		battingScore.setFours(5);
		battingScore.setSixers(2);
		battingScores.add(battingScore);

		return battingScores;
	}

	private List<BowlingScore> getGTBowlingScores() {
		List<BowlingScore> bowlingScores = new ArrayList<BowlingScore>();

		// Shami
		BowlingScore bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(62));
		bowlingScore.setOvers(4.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(39);
		bowlingScore.setWickets(1);
		bowlingScores.add(bowlingScore);

		// Sangwan
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(59));
		bowlingScore.setOvers(4.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(19);
		bowlingScore.setWickets(2);
		bowlingScores.add(bowlingScore);

		// Joseph
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(60));
		bowlingScore.setOvers(4.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(42);
		bowlingScore.setWickets(1);
		bowlingScores.add(bowlingScore);

		// Rashid
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(58));
		bowlingScore.setOvers(4.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(29);
		bowlingScore.setWickets(1);
		bowlingScores.add(bowlingScore);

		// Lockie
		bowlingScore = new BowlingScore();
		bowlingScore.setPlayer(getPlayerDB(61));
		bowlingScore.setOvers(4.0);
		bowlingScore.setMaidens(0);
		bowlingScore.setRunsGiven(36);
		bowlingScore.setWickets(1);
		bowlingScores.add(bowlingScore);

		return bowlingScores;
	}

	private List<BattingScore> getRCBBattingScores() {
		List<BattingScore> battingScores = new ArrayList<BattingScore>();

		// Virat
		BattingScore battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(12));
		battingScore.setRuns(58);
		battingScore.setBalls(53);
		battingScore.setFours(6);
		battingScore.setSixers(1);

		Dismissal dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(62));
		dismissal.setDismissalType("Bowled");
		battingScore.setDismissal(dismissal);

		battingScores.add(battingScore);

		// Faf
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(11));
		battingScore.setRuns(0);
		battingScore.setBalls(4);
		battingScore.setFours(0);
		battingScore.setSixers(0);

		dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(59));
		dismissal.setFielder(getPlayerDB(54));
		dismissal.setDismissalType("Caught");
		battingScore.setDismissal(dismissal);
		battingScores.add(battingScore);

		// Rajat
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(13));
		battingScore.setRuns(52);
		battingScore.setBalls(32);
		battingScore.setFours(5);
		battingScore.setSixers(2);

		dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(59));
		dismissal.setFielder(getPlayerDB(55));
		dismissal.setDismissalType("Caught");
		battingScore.setDismissal(dismissal);
		battingScores.add(battingScore);

		// Maxwell
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(14));
		battingScore.setRuns(33);
		battingScore.setBalls(18);
		battingScore.setFours(3);
		battingScore.setSixers(2);

		dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(61));
		dismissal.setFielder(getPlayerDB(58));
		dismissal.setDismissalType("Caught");
		battingScore.setDismissal(dismissal);
		battingScores.add(battingScore);

		// Karthik
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(15));
		battingScore.setRuns(2);
		battingScore.setBalls(3);
		battingScore.setFours(0);
		battingScore.setSixers(0);

		dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(58));
		dismissal.setFielder(getPlayerDB(62));
		dismissal.setDismissalType("Caught");
		battingScore.setDismissal(dismissal);
		battingScores.add(battingScore);

		// Shahbaz
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(16));
		battingScore.setRuns(2);
		battingScore.setBalls(2);
		battingScore.setFours(0);
		battingScore.setSixers(0);

		battingScores.add(battingScore);

		// Lomror
		battingScore = new BattingScore();
		battingScore.setPlayer(getPlayerDB(17));
		battingScore.setRuns(16);
		battingScore.setBalls(8);
		battingScore.setFours(2);
		battingScore.setSixers(1);

		dismissal = new Dismissal();
		dismissal.setBowler(getPlayerDB(60));
		dismissal.setFielder(getPlayerDB(56));
		dismissal.setDismissalType("Caught");
		battingScore.setDismissal(dismissal);
		battingScores.add(battingScore);

		return battingScores;
	}

	private User getPlayerDB(int id) {
		return userRepo.findById(id).get();
	}

	private Tournament getIPLDB() {
		return tourRepo.findById(25).get();
	}

	private Team getTeamGTDB() {
		Team gt = teamRepo.findById(52).get();
		return gt;
	}

	@GetMapping(path = "/addMatchData")
	public String addMatchData() {
		CricketMatch match = new CricketMatch();
		match.setTeam1(getTeamRCBDB());
//		match.setTeam2(getTeamGT());

//		match.setMom(getTewatia());
//		match.setWinningTeam(getTeamGT());
		match.setMatchType("T20");
		match.setTournament(getIPL());

		matchrepo.save(match);
		return "succses";
	}

	private Team getTeamRCBDB() {
		Team rcb = teamRepo.findById(10).get();
		return rcb;
	}

	@GetMapping(path = "/saveRCB")
	public String saveRCB() {
		Team team = getTeamRCB();
		teamRepo.save(team);
		return "succses";
	}

	@GetMapping(path = "/saveGT")
	public String saveGT() {
		Team team = getTeamGT();
		teamRepo.save(team);
		return "succses";
	}

	private Tournament getIPL() {
		Tournament tour = new Tournament();
		tour.setName("IPLT20");
		tour.setTeams(getIPLTeams());
		tour.setEndDate(new Date(122, 5, 30));
		tour.setStartDate(new Date(122, 4, 4));

		return tour;
	}

	private List<Team> getIPLTeams() {
		List<Team> team = new ArrayList<>();
//		team.add(getTeamGT());
		team.add(getTeamRCBDB());
		return team;
	}

	private Team getTeamGT() {

		User hardik = getHardik();
		Team gt = new Team();
		gt.setTeamName("GT");
		gt.setCaptain(hardik);
		gt.setLocation("Ahmedabad");
		gt.setSize(16);
		gt.setTeamIdentifier("#v1swq");

		List<User> players = populateGTPlayers();
		players.add(hardik);
		gt.setPlayers(players);

		return gt;
	}

	private List<User> populateGTPlayers() {
		List<User> gtPlayers = new ArrayList<>();

		User Wriddhiman = getSaha();
		gtPlayers.add(Wriddhiman);

		User Shubman = getGill();
		gtPlayers.add(Shubman);

		User David = getMiller();
		gtPlayers.add(David);

		User Rahul = getTewatia();
		gtPlayers.add(Rahul);

		User Rashid = getRashid();
		gtPlayers.add(Rashid);

		User Pradeep = getPradeep();
		gtPlayers.add(Pradeep);

		User Alzarri = getAlzarri();
		gtPlayers.add(Alzarri);

		User Lockie = getLockie();
		gtPlayers.add(Lockie);

		User Mohammed = getShami();
		gtPlayers.add(Mohammed);

		User sai = getSai();
		gtPlayers.add(sai);

		return gtPlayers;
	}

	private User getSai() {
		User sai = new User();
		sai.setBattingStyle("Right Handed Bat");
		sai.setBowlingStyle("Right-arm fast-medium");
		sai.setDob(new Date(93, 10, 11));
		sai.setUserFName("sai");
		sai.setUserLName("Sudharsan");
		sai.setEmail("sai.Sudharsan@gmail.com");
		sai.setRole("Batting Allrounder");
		return sai;
	}

	private User getShami() {
		User Mohammed = new User();
		Mohammed.setBattingStyle("Right Handed Bat");
		Mohammed.setBowlingStyle("Right-arm fast-medium");
		Mohammed.setDob(new Date(90, 9, 3));
		Mohammed.setUserFName("Mohammed");
		Mohammed.setUserLName("Shami");
		Mohammed.setEmail("Mohammed.Shami@gmail.com");
		Mohammed.setRole("Bowler");
		return Mohammed;
	}

	private User getLockie() {
		User Lockie = new User();
		Lockie.setBattingStyle("Right Handed Bat");
		Lockie.setBowlingStyle("Right-arm fast-medium");
		Lockie.setDob(new Date(9, 6, 13));
		Lockie.setUserFName("Lockie");
		Lockie.setUserLName("Ferguson");
		Lockie.setEmail("Lockie.Ferguson@gmail.com");
		Lockie.setRole("Bowler");
		return Lockie;
	}

	private User getAlzarri() {
		User Alzarri = new User();
		Alzarri.setBattingStyle("Right Handed Bat");
		Alzarri.setBowlingStyle("Right-arm fast-medium");
		Alzarri.setDob(new Date(96, 11, 20));
		Alzarri.setUserFName("Alzarri");
		Alzarri.setUserLName("Joseph");
		Alzarri.setEmail("Alzarri.Joseph@gmail.com");
		Alzarri.setRole("Bowler");
		return Alzarri;
	}

	private User getPradeep() {
		User Pradeep = new User();
		Pradeep.setBattingStyle("Right Handed Bat");
		Pradeep.setBowlingStyle("Left-arm fast-medium");
		Pradeep.setDob(new Date(93, 10, 11));
		Pradeep.setUserFName("Pradeep");
		Pradeep.setUserLName("Sangwan");
		Pradeep.setEmail("Pradeep.Sangwan@gmail.com");
		Pradeep.setRole("Bowler");
		return Pradeep;
	}

	private User getRashid() {
		User Rashid = new User();
		Rashid.setBattingStyle("Right Handed Bat");
		Rashid.setBowlingStyle("Right-arm legbreak");
		Rashid.setDob(new Date(98, 9, 20));
		Rashid.setUserFName("Rashid");
		Rashid.setUserLName("Khan");
		Rashid.setEmail("Rashid.khan@gmail.com");
		Rashid.setRole("Bowling Allrounder");
		return Rashid;
	}

	private User getTewatia() {
		User Rahul = new User();
		Rahul.setBattingStyle("Left Handed Bat");
		Rahul.setBowlingStyle("Right-arm legbreak");
		Rahul.setDob(new Date(93, 05, 20));
		Rahul.setUserFName("Rahul");
		Rahul.setUserLName("Tewatia");
		Rahul.setEmail("Rahul.Tewatia@gmail.com");
		Rahul.setRole("Batting Allrounder");
		return Rahul;
	}

	private User getTewatiaDB() {
		User user = userRepo.findById(57).get();
		return user;
	}

	private User getMiller() {
		User David = new User();
		David.setBattingStyle("Left Handed Bat");
		David.setBowlingStyle("Right-arm offbreak");
		David.setDob(new Date(101, 10, 15));
		David.setUserFName("David");
		David.setUserLName("Miller");
		David.setEmail("David.miller@gmail.com");
		David.setRole("Batsman");
		return David;
	}

	private User getGill() {
		User Shubman = new User();
		Shubman.setBattingStyle("Right Handed Bat");
		Shubman.setBowlingStyle("Right-arm offbreak");
		Shubman.setDob(new Date(99, 9, 8));
		Shubman.setUserFName("Shubman");
		Shubman.setUserLName("Gill");
		Shubman.setEmail("Shubman.gill@gmail.com");
		Shubman.setRole("Batsman");
		return Shubman;
	}

	private User getSaha() {
		User Wriddhiman = new User();
		Wriddhiman.setBattingStyle("Right Handed Bat");
		Wriddhiman.setBowlingStyle("Right-arm fast-medium");
		Wriddhiman.setDob(new Date(84, 10, 24));
		Wriddhiman.setUserFName("Wriddhiman");
		Wriddhiman.setUserLName("Saha");
		Wriddhiman.setEmail("Wriddhiman.saha@gmail.com");
		Wriddhiman.setRole("WK-Batsman");
		return Wriddhiman;
	}

	private User getHardik() {
		User hardik = new User();
		hardik.setBattingStyle("Right Handed Bat");
		hardik.setBowlingStyle("Right-arm fast-medium");
		hardik.setDob(new Date(93, 10, 11));
		hardik.setUserFName("Hardik");
		hardik.setUserLName("Pandya");
		hardik.setEmail("hardik.pandya@gmail.com");
		hardik.setRole("Batting Allrounder");
		return hardik;
	}

	private Team getTeamRCB() {

		Team rcb = new Team();
		User faf = getFaf();
		rcb.setTeamName("RCB");
		rcb.setCaptain(faf);
		rcb.setLocation("Bengaluru");
		rcb.setSize(16);
		rcb.setTeamIdentifier("#b1sc9");

		List<User> players = populateRCBPlayers();
		players.add(faf);
		rcb.setPlayers(players);

		return rcb;
	}

	private List<User> populateRCBPlayers() {
		List<User> rcbPlayers = new ArrayList<>();

		User Kohli = getKohli();
		rcbPlayers.add(Kohli);

		User rajat = getRajat();
		rcbPlayers.add(rajat);

		User glen = getGlen();
		rcbPlayers.add(glen);

		User karthik = getKarthik();
		rcbPlayers.add(karthik);

		User shahbaz = getShahbaz();
		rcbPlayers.add(shahbaz);

		User Mahi = getMahipal();
		rcbPlayers.add(Mahi);

		User hasaranga = getHasaranga();
		rcbPlayers.add(hasaranga);

		User harshal = getHarshal();
		rcbPlayers.add(harshal);

		User Siraj = getSiraj();
		rcbPlayers.add(Siraj);

		User Hazelwood = getHazelwood();
		rcbPlayers.add(Hazelwood);

		return rcbPlayers;
	}

	private User getHazelwood() {
		User Hazelwood = new User();
		Hazelwood.setBattingStyle("Left Handed Bat");
		Hazelwood.setBowlingStyle("Right-arm fast-medium");
		Hazelwood.setDob(new Date(91, 1, 8));
		Hazelwood.setUserFName("Hazlewood");
		Hazelwood.setUserLName("Josh");
		Hazelwood.setEmail("Hazelwood.Josh@gmail.com");
		Hazelwood.setRole("Bowler");
		return Hazelwood;
	}

	private User getSiraj() {
		User Siraj = new User();
		Siraj.setBattingStyle("Right Handed Bat");
		Siraj.setBowlingStyle("Right-arm fast-medium");
		Siraj.setDob(new Date(94, 3, 13));
		Siraj.setUserFName("Mohammed");
		Siraj.setUserLName("Siraj");
		Siraj.setEmail("Siraj.mohammed@gmail.com");
		Siraj.setRole("Bowler");
		return Siraj;
	}

	private User getHarshal() {
		User harshal = new User();
		harshal.setBattingStyle("Right Handed Bat");
		harshal.setBowlingStyle("Right-arm fast-medium");
		harshal.setDob(new Date(90, 11, 23));
		harshal.setUserFName("harshal");
		harshal.setUserLName("du Patel");
		harshal.setEmail("harshal.patel@gmail.com");
		harshal.setRole("Bowler");
		return harshal;
	}

	private User getHasaranga() {
		User hasaranga = new User();
		hasaranga.setBattingStyle("Right Handed Bat");
		hasaranga.setBowlingStyle("Right-arm legbreak");
		hasaranga.setDob(new Date(97, 7, 29));
		hasaranga.setUserFName("hasaranga");
		hasaranga.setUserLName("du Plessis");
		hasaranga.setEmail("hasaranga.wanindu@gmail.com");
		hasaranga.setRole("Bowling Allrounder");
		return hasaranga;
	}

	private User getMahipal() {
		User Mahi = new User();
		Mahi.setBattingStyle("Left Handed Bat");
		Mahi.setBowlingStyle("Left-arm orthodox");
		Mahi.setDob(new Date(84, 7, 13));
		Mahi.setUserFName("Mahipal");
		Mahi.setUserLName("lomror");
		Mahi.setEmail("Mahi.lomror@gmail.com");
		Mahi.setRole("Batting Allrounder");
		return Mahi;
	}

	private User getShahbaz() {
		User shahbaz = new User();
		shahbaz.setBattingStyle("Left Handed Bat");
		shahbaz.setBowlingStyle("Left-arm orthodox");
		shahbaz.setDob(new Date(94, 12, 12));
		shahbaz.setUserFName("shahbaz");
		shahbaz.setUserLName("Ahmed");
		shahbaz.setEmail("shahbaz.duplessis@gmail.com");
		shahbaz.setRole("Bowling Allrounder");
		return shahbaz;
	}

	private User getKarthik() {
		User karthik = new User();
		karthik.setBattingStyle("Right Handed Bat");
		karthik.setBowlingStyle("Right-arm legbreak");
		karthik.setDob(new Date(85, 6, 1));
		karthik.setUserFName("Dinesh");
		karthik.setUserLName("Karthik");
		karthik.setEmail("karthik.dinesh@gmail.com");
		karthik.setRole("WK-Batsman");
		return karthik;
	}

	private User getGlen() {
		User glen = new User();
		glen.setBattingStyle("Right Handed Bat");
		glen.setBowlingStyle("Right-arm offbreak");
		glen.setDob(new Date(88, 10, 14));
		glen.setUserFName("Glenn");
		glen.setUserLName("Maxwell");
		glen.setEmail("glenn.maxwell@gmail.com");
		glen.setRole("Batting Allrounder");
		return glen;
	}

	private User getRajat() {
		User rajat = new User();
		rajat.setBattingStyle("Right Handed Bat");
		rajat.setBowlingStyle("Right-arm offbreak");
		rajat.setDob(new Date(93, 7, 1));
		rajat.setUserFName("Rajat");
		rajat.setUserLName("Patidar");
		rajat.setEmail("rajat.patidar@gmail.com");
		rajat.setRole("Batsmen");
		return rajat;
	}

	private User getKohli() {
		User Kohli = new User();
		Kohli.setBattingStyle("Right Handed Bat");
		Kohli.setBowlingStyle("Right-arm medum");
		Kohli.setDob(new Date(88, 11, 5));
		Kohli.setUserFName("Virat");
		Kohli.setUserLName("Kohli");
		Kohli.setEmail("Virat.kohli@gmail.com");
		Kohli.setRole("Batsmen");
		return Kohli;
	}

	private User getFaf() {
		User faf = new User();
		faf.setBattingStyle("Right Handed Bat");
		faf.setBowlingStyle("Right-arm legbreak");
		faf.setDob(new Date(84, 7, 13));
		faf.setUserFName("Faf");
		faf.setUserLName("du Plessis");
		faf.setEmail("faf.duplessis@gmail.com");
		faf.setRole("Batsmen");

		return faf;
	}
}
