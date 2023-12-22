package com.activity.bankapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name="creditscore")
public class CreditScore {
	
	@Id
	private long pan;
	private int score;
	public CreditScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditScore(long pan, int score) {
		super();
		this.pan = pan;
		this.score = score;
	}
	public long getPan() {
		return pan;
	}
	public void setPan(long pan) {
		this.pan = pan;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
