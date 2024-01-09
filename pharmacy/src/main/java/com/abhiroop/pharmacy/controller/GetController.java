package com.abhiroop.pharmacy.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhiroop.pharmacy.model.Inventory;
import com.abhiroop.pharmacy.model.Med;
import com.abhiroop.pharmacy.model.OrderDue;

@RestController
public class GetController {
    
    @RequestMapping(value = "/" ,method = RequestMethod.GET,headers = "Accept=application/json")
	public String heartbeat(Model model) {

		return "Pharma-service App is ready";
	}

	@RequestMapping(value = "/totalSale", method = RequestMethod.GET, headers = "Accept=application/json")
	public String totalSale(Model model) {

		return String.valueOf(320000.00);
	}
	@RequestMapping(value = "/currentMonthSale", method = RequestMethod.GET, headers = "Accept=application/json")
	public String currentMonthSale(Model model) {

		return String.valueOf(10300.00);
	}
	
	@RequestMapping(value = "/currentMonthReturnsValue", method = RequestMethod.GET, headers = "Accept=application/json")
	public String currentMonthReturnsValue(Model model) {

		return String.valueOf(4600.00);
	}

	@RequestMapping(value = "/getInventory", method = RequestMethod.GET, headers = "Accept=application/json")
	public Inventory getInventory(Model model) {

		Inventory  inv = new Inventory();
		inv.setNearestExpiry("12/30/2023");
		inv.setNoOfBoxes(27);
		inv.setTotalValue(34000.5);
		return inv;
	}


	@RequestMapping(value = "/getDueOrders", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<OrderDue> getDueOrders() {
	

		return dueOrderList();
	}

	@RequestMapping(value = "/getDueOrderById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public OrderDue getDueOrderById(@PathVariable int id) {
		OrderDue c = null;
		if (getDueOrders() != null && id > 0) {

			for (OrderDue o : getDueOrders()) {
				if(o.getOrderId().equals(String.valueOf(id))){
					c=o;
					break;
				}
			}
			
		}
		return c;

	}

	List<OrderDue> dueOrderList(){
		List<OrderDue> objects = new ArrayList<OrderDue>();

        //Populating random objects
        objects.add(new OrderDue("234", "01/10/2024",18.5,"12/31/2023",getMedList("234")));
        objects.add(new OrderDue("456", "01/08/2024",318.25,"12/27/2023",getMedList("456")));
		objects.add(new OrderDue("789", "01/05/2024",168.58,"12/26/2023",getMedList("789")));
		objects.add(new OrderDue("1011", "12/30/2023",189.15,"12/25/2023",getMedList("1011")));
	return objects;				

	}

	private List<Med> getMedList(String d) {
		List<Med> meds = new ArrayList<Med>();
		System.out.println("Add new med to meds list");
		meds.add(new Med("Atarax","Allopathy",3.05,Date.valueOf("2023-11-31"),"NM6987")));
		return meds;
	}
}
