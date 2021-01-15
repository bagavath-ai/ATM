package com.example.demo.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@javax.persistence.Table(name="atm")
public class atmtable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="\"id\"")
	private BigInteger id;
	@Column(name = "\"amt\"")
	private Integer amt;
	@Column(name = "\"sno\"")
	private Integer sno;
}
