package com.hexa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hexa.dao.EmpDao;
import com.hexa.dao.NotFoundException;
import com.hexa.entity.Emp;

@Controller
public class EmpController {
	private Logger logger = LoggerFactory.getLogger("empapp");
	@Autowired
	private EmpDao dao;

	@RequestMapping(value = { "/", "/main" })
	public String displayHome() {
		logger.debug("displaying Home Page");
		return "Main";
	}

	@RequestMapping(value = "/viewall")
	public String viewAllEmployee(@RequestParam(value = "pno") Integer pgno, Model model) {
		logger.debug("inside viewAllEmployees method");

		List<Emp> lst = dao.getEmployees();
		prepareEmployee(pgno, "viewall?", lst, model);
		return "EmpView";
	}

	public void prepareEmployee(int pgno, String pgurl, List<Emp> lst, Model model) {
		int end = pgno * 3;
		int start = end - 3;
		if (end >= lst.size())
			end = lst.size();
		int lastpg = (int) Math.ceil(lst.size() / 3.0);
		List<Emp> sublist = lst.subList(start, end);
		model.addAttribute("elist", sublist);
		model.addAttribute("lastpg", lastpg);
		model.addAttribute("pgurl", pgurl);
	}

	@RequestMapping("/idfrm")
	public String displayIdFrm() {
		return "EmpIdFrm";
	}

	@RequestMapping("/viewbyid")
	public String viewEmployeeById(@RequestParam("txteid") Integer eid, Model model) throws NotFoundException {
		model.addAttribute("emp", dao.getEmployee(eid));
		return "EmpIdView";
	}

	@RequestMapping("/viewdepts")
	public String displayDeptFrm(Model model) {
		model.addAttribute("dlist", dao.getDepartments());
		return "DeptFrm";
	}

	@RequestMapping("/viewbydept")
	public String viewByDept(@RequestParam("pno") Integer pgno, @RequestParam("cbodept") Integer did, Model model) {
		List<Emp> lst = dao.getEmployees(did);
		prepareEmployee(pgno, "viewbydept?cbodept=" + did + "&", lst, model);

		return "EmpView";
	}

	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleException(NotFoundException ex) {
		return new ModelAndView("MyErr", "err", ex.getMessage());
	}

}
