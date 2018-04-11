package com.hexa.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hexa.entity.Dept;
import com.hexa.entity.Emp;

@Repository("mydao")
public class EmpDaoImpl implements EmpDao {
	private Logger logger = LoggerFactory.getLogger("empapp");
	private SessionFactory sfac;

	// setter for spring IOC to do DI

	@Autowired
	public void setSfac(SessionFactory sfac) {
		logger.info("session factory is injected");
		this.sfac = sfac;
	}

	@Override
	public List<Dept> getDepartments() {
		logger.debug("inside getDepartments method");
		Session sess = sfac.openSession();
		Query qry = sess.createQuery("from Dept d");
		List<Dept> lst = qry.list();
		sess.close();
		logger.info("fetched departments" + lst.size());
		return lst;

	}

	@Override
	public List<Emp> getEmployees() {
		// TODO Auto-generated method stub
		logger.debug("inside getEmployees method");
		Session sess = sfac.openSession();
		String hql = "from Emp e left join fetch e.dept";

		Query qry = sess.createQuery(hql);

		List<Emp> lst = qry.list();
		sess.close();
		logger.info("fetched employees" + lst.size());
		return lst;
	}
	/**
	 * @param did department id
	 * @return list of employee
	 * <p> This methods returns a list of emp instances for the department id. </p>
	 */
	@Override
	public List<Emp> getEmployees(int did) {
		// TODO Auto-generated method stub
		logger.debug("inside getEmployee by did method");
		Session sess = sfac.openSession();

		String hql = "from Emp e left join fetch e.dept where e.dept.deptId=?";

		Query qry = sess.createQuery(hql);
		qry.setInteger(0, did);

		List<Emp> lst = qry.list();
		sess.close();
		logger.info("fetched employees by dept id" + did + lst.size());
		return lst;
	}

	@Override
	public Emp getEmployee(int eid) throws NotFoundException {
		// TODO Auto-generated method stub
		logger.debug("inside getEmployee by eid method");
		Session sess = sfac.openSession();
		String hql = "from Emp e left join fetch e.dept where e.empId=?";

		Query qry = sess.createQuery(hql);
		qry.setInteger(0, eid);
		Emp emp = (Emp) qry.uniqueResult();
		sess.close();

		if (emp == null) {
			logger.error("NotFoundException raised");
			throw new NotFoundException("Employee not found for Id" + eid);
		}
		logger.info(emp.toString());
		return emp;
	}

	@Override
	public int addEmployee(Emp emp) throws IdException {
		// TODO Auto-generated method stub
		logger.debug("inside addEmployee method");
		Session sess = sfac.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			sess.save(emp);
			tx.commit();
			logger.info("employee inserted");
			return 1;
		} catch (HibernateException ex) {
			tx.rollback();
			logger.error("IdException is raised" + ex.getMessage());
			throw new IdException("Emp Id already exists!!");
		} finally {
			sess.close();
		}
	}

}
