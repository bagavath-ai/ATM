package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.atmtable;
import com.example.demo.repo.atm;

@RestController
public class Restcontroller {

	@Autowired
	atm atmrepo;

	@GetMapping(value = "/")
	public String welcomeatm() {

		List<atmtable> atmvalue = atmrepo.findAll();
		List valuedem;
		Integer valueofdeno = 0;
		for (int i = 0; i < atmvalue.size(); i++) {

			valueofdeno += atmvalue.get(i).getAmt() * atmvalue.get(i).getSno();

		}

		System.out.print(valueofdeno);

		return "Total value of ATM--" + valueofdeno;

	}

	@GetMapping(value = "/{value}")
	public String welcomeatmvalue(@PathVariable("value") Integer val) {

		List<atmtable> atmvalue = atmrepo.findAll();
		List valuedem;
		Integer valueofdeno = 0;
		int[] count = { 0, 0, 0, 0, 0 };
		int totalCorpus;
		for (int i = 0; i < atmvalue.size(); i++) {

			valueofdeno += atmvalue.get(i).getAmt() * atmvalue.get(i).getSno();

		}

		if (val <= valueofdeno) {
			int[] noteCounter = new int[9];
			String response = "Total value of ATM--" + valueofdeno + "<br>";
			response += "Enter value:" + val;
			response += "<table border=\"1\">\r\n" + "<tr>\r\n" + "<th>TotalAmount</th><th>S.No</th><th>Amount</th>\r\n"
					+ "</tr>";
			for (int i = 0; i < atmvalue.size(); i++) {

				int noteCount = val / atmvalue.get(i).getAmt();

				count[i] = noteCount >= atmvalue.get(i).getSno() ? atmvalue.get(i).getSno() : noteCount;

//                response+="No of notes"+count[i]+"Amout"+atmvalue.get(i).getAmt()+"Total Value"+atmvalue.get(i).getAmt()*count[i]+"<br>";

				response += "<tr>\r\n" + "<td>" + count[i] * atmvalue.get(i).getAmt() + "</td><td>" + count[i]
						+ "</td><td>" + atmvalue.get(i).getAmt() + "</td>\r\n" + "</tr>";
			}
			response += "</table>\r\n" + "";

			return response;

		} else {
			String rest = "Total value of ATM--" + val;

			return "Amount is lesser that you enterd";
		}

	}

}
