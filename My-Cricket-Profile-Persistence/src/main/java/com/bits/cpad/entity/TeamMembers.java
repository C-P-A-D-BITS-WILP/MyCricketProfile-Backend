package com.bits.cpad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="team_members")
public class TeamMembers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "team_fk", referencedColumnName = "id")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name = "player_fk", referencedColumnName = "id")
	private User player;
	
	@Column(name = "player_status")
	private String playerStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public String getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
	}
}
