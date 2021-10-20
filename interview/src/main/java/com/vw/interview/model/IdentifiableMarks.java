package com.vw.interview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "identifiablemarks")
public class IdentifiableMarks implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long identifiableMarksId;
	private String side;
	private String location;
	private String mark;
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "unicorn_unicorn_id")
	private Unicorn unicorn;

	public IdentifiableMarks() {
	}

	public IdentifiableMarks(String side, String location, String mark, String color, Unicorn unicorn) {
		this.side = side;
		this.location = location;
		this.mark = mark;
		this.color = color;
		this.unicorn = unicorn;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getIdentifiableMarksId() {
        return identifiableMarksId;
    }
    public void setIdentifiableMarksId(long identifiableMarksId) {
        this.identifiableMarksId = identifiableMarksId;
    }
    
    @Column(name = "side")
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	
	@Column(name = "location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name = "mark")
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@Column(name = "color")
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
    
    
}
