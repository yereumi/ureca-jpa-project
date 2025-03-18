package kr.co.ureca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping(value = "/empAll", method = RequestMethod.GET)
	public String empFindAll() {
		List<Emp> list = empService.empFindAll();
		System.out.println("empFindAll : " + list);

		return "hello";
	} // empFindAll

	@RequestMapping(value = "/empByName", method = RequestMethod.GET)
	public String empFindByName() {
		String ename = "MILLER";
		String job = "CLERK";
		Integer sal = 1300;

		Emp empEntity = empService.empFindByName(ename);
		System.out.println("empFindByName : " + empEntity);

		empEntity = empService.empFindByNameAndSal(ename, sal);
		System.out.println("empFindByNameAndSal : " + empEntity);

		empEntity = empService.empFindByNameAndJobAndSal(ename, job, sal);
		System.out.println("empFindByNameAndJobAndSal : " + empEntity);

		List<Emp> list = empService.empFindByNameOrJobOrSal(ename, job, 3000);
		System.out.println("empFindByNameOrJobOrSal : " + list);

		list = empService.empFindByJobLike("%SALES%");
		System.out.println("empFindByJobLike : " + list);

		return "hello";
	} // empFindByName

	@RequestMapping(value = "/empIns", method = RequestMethod.GET)
	public String empInsert() {
		Emp newEmp = new Emp();
		newEmp.setEmpno(Integer.valueOf(9999));
		newEmp.setEname("Hong");
		newEmp.setJob("CLERK");
		newEmp.setSal(Integer.valueOf(1200));
		newEmp.setComm(Integer.valueOf(600));
		newEmp.setDeptno(Integer.valueOf(40));
		Long primaryKey = empService.empInsert(newEmp);
		System.out.println("empInsert : " + primaryKey);

		return "hello";
	} // empInsert

	@RequestMapping(value = "/empUp", method = RequestMethod.GET)
	public String empUpdate() {
		Emp upEmp = new Emp();
		upEmp.setId(15L);
		upEmp.setEname("HongGD");
		upEmp.setJob("ANALIST");
		upEmp.setSal(Integer.valueOf(2400));
		upEmp.setComm(null);
		upEmp.setDeptno(Integer.valueOf(20));
		Emp empAfterUpdate = empService.empUpdate(upEmp);
		System.out.println("empUpdate : " + empAfterUpdate);

		return "hello";
	} // empUpdate

	@RequestMapping(value = "/empDel", method = RequestMethod.GET)
	public String empDelete() {
		Emp empDel = new Emp();
		empDel.setId(15L);
		empService.empDelete( empDel );

		return "hello";
	} // empDelete

	@RequestMapping(value = "empQuery", method = RequestMethod.GET)
	public String findByQuery() {
		String ename = "MARTIN";
		String job = "SALESMAN";
		Integer sal = 3000;

		Emp empEntity = empService.findByQueryEname(ename);
		System.out.println("findByQueryEname : " + empEntity);

		List<Emp> list = empService.findByQueryJob( job );
		System.out.println("findByQueryJob : " + list);

		return "hello";
	} // findByQuery

	@RequestMapping(value = "/empOrder", method = RequestMethod.GET)
	public String empFindOrderBy() {
		String job = "CLERK";
		List<Emp> list = empService.empFindOrderBy(job);
		System.out.println("empFindOrderBy : " + list);

		return "hello";
	} // empFindOrderBy

	@RequestMapping(value = "/empThan", method = RequestMethod.GET)
	public String empFindThan() {
		Integer sal = 3000;
		List<Emp> list = empService.empFindLessThan(sal);
		System.out.println("empFindLessThan : " + list);

		list = empService.empFindLessThanEqual(sal);
		System.out.println("empFindLessThanEqual : " + list);

		list = empService.empFindGreaterThan(sal);
		System.out.println("empFindGreaterThan : " + list);

		list = empService.empFindGreaterThanEqual(sal);
		System.out.println("empFindGreaterThanEqual : " + list);

		return "hello";
	} // empFindThan

} // class








