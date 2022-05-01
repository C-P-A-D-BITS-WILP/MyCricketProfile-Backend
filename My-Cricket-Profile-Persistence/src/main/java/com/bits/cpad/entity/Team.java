package com.bits.cpad.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({ @NamedQuery(name = "findByUserId", query = "from Team t where t.owner.id = :userId") })
@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "team_identifier")
	private String teamIdentifier;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_fk", referencedColumnName = "id")
	private User owner;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "captain_fk", referencedColumnName = "id")
	private User captain;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "team_members", joinColumns = { @JoinColumn(name = "team_fk") }, inverseJoinColumns = {
			@JoinColumn(name = "player_fk") })
	private List<User> players;

	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
	private List<TeamMembers> teamMembers;

	@ManyToMany(mappedBy = "teams", fetch = FetchType.LAZY)
	private List<Tournament> tournaments;

	private String location;

	private Integer size;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamIdentifier() {
		return teamIdentifier;
	}

	public void setTeamIdentifier(String teamIdentifier) {
		this.teamIdentifier = teamIdentifier;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getCaptain() {
		return captain;
	}

	public void setCaptain(User captain) {
		this.captain = captain;
	}

	public List<User> getPlayers() {
		return players;
	}

	public void setPlayers(List<User> players) {
		this.players = players;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public List<TeamMembers> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<TeamMembers> teamMembers) {
		this.teamMembers = teamMembers;
	}

}
