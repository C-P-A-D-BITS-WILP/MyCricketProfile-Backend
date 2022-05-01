package com.bits.cpad.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="batting_score")
public class BattingScore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer balls;

	private Integer runs;

	private Integer fours;

	private Integer sixers;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dismissal_fk")
	private Dismissal dismissal;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "player_fk")
	private User player;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "innings_fk")
	private InningsScore innings;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBalls() {
		return balls;
	}

	public void setBalls(Integer balls) {
		this.balls = balls;
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	public Integer getFours() {
		return fours;
	}

	public void setFours(Integer fours) {
		this.fours = fours;
	}

	public Integer getSixers() {
		return sixers;
	}

	public void setSixers(Integer sixers) {
		this.sixers = sixers;
	}

	public Dismissal getDismissal() {
		return dismissal;
	}

	public void setDismissal(Dismissal dismissal) {
		this.dismissal = dismissal;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public InningsScore getInnings() {
		return innings;
	}

	public void setInnings(InningsScore innings) {
		this.innings = innings;
	}

}
