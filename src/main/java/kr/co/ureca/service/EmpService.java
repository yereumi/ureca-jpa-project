package kr.co.ureca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;

	public List<Emp> empFindAll() {
		List<Emp> list = empRepository.findAll();
		return list;
	} // empFindAll

	public Emp empFindByName(String ename) {
		Emp empEntity = empRepository.findByEname(ename);
		return empEntity;
	} // empFindByName

	public Emp empFindByNameAndSal(String ename, Integer sal) {
		Emp empEntity = empRepository.findByEnameAndSal(ename, sal);
		return empEntity;
	} // empFindByNameNSal

	public Emp empFindByNameAndJobAndSal(String ename, String job, Integer sal) {
		Emp empEntity = empRepository.findByEnameAndJobAndSal(ename, job, sal);
		return empEntity;
	} // empFindByNameAndJobAndSal

	public List<Emp> empFindByNameOrJobOrSal(String ename, String job, Integer sal) {
		List<Emp> list = empRepository.findByEnameOrJobOrSal(ename, job, sal);
		return list;
	} // empFindByNameOrJobOrSal

	public List<Emp> empFindByJobLike(String job) {
		List<Emp> list = empRepository.findByJobLike(job);
		return list;
	} // empFindByJobLike

	public List<Emp> empFindOrderBy(String job) {
		List<Emp> list = empRepository.findByJobOrderByDeptnoDescEnameAsc(job);
		return list;
	} // empFindOrderBy

	public List<Emp> empFindLessThan(Integer sal) {
		List<Emp> list = empRepository.findBySalLessThan(sal);
		return list;
	} // empFindLessThan

	public List<Emp> empFindLessThanEqual(Integer sal) {
		List<Emp> list = empRepository.findBySalLessThanEqual(sal);
		return list;
	} // empFindLessThanEqual

	public List<Emp> empFindGreaterThan(Integer sal) {
		List<Emp> list = empRepository.findBySalGreaterThan(sal);
		return list;
	} // empFindGreaterThan

	public List<Emp> empFindGreaterThanEqual(Integer sal) {
		List<Emp> list = empRepository.findBySalGreaterThanEqual(sal);
		return list;
	} // empFindGreaterThanEqual

	public Long empInsert(Emp newEmp) { // 저장 전 객체는 PK가 null.
		Emp saveAfterEmp = empRepository.save(newEmp);
		return saveAfterEmp.getId(); // 저장 후 객체는 PK가 생성되어 있음.
	} // empInsert

	public Emp empUpdate(Emp upEmp) {
		Optional<Emp> optEmp = empRepository.findById( upEmp.getId() );

		Emp empEntity = optEmp.get();
		empEntity.setEname( upEmp.getEname() );
		empEntity.setJob( upEmp.getJob() );
		empEntity.setSal( upEmp.getSal() );
		empEntity.setComm( upEmp.getComm() );
		empEntity.setDeptno( upEmp.getDeptno() );

		Emp empAfterUpdate = empRepository.save(empEntity);
		return empAfterUpdate;
	} // empUpdate

	public void empDelete(Emp empDel) {
		Optional<Emp> optEmp = empRepository.findById( empDel.getId() );
		Emp empEntity = optEmp.get();
		empRepository.delete(empEntity);
	} // empDelete

	public Emp findByQueryEname(String ename) {
		Emp empEntity = null;
//		empEntity = empRepository.findByQueryEname(ename);
		empEntity = empRepository.findByQueryEnameParam(ename);
		// findByQueryEname과 findByQueryEnameParam은 같은 쿼리, 다른 표현임.
		return empEntity;
	} // findByQueryEname

	public List<Emp> findByQueryJob(String job) {
		List<Emp> empList = null;
		empList = empRepository.findByQueryJobParam(job);
		// findByQueryJobParam과 findByQueryJob은 같은 쿼리, 다른 표현, 다른 return 값.

//		List<Object[]> list = empRepository.findByQueryJob(job);
//		empList = new ArrayList<>();
//		for (Object[] objs : list) {
//			Emp tmpEmp = new Emp();
//			tmpEmp.setId( (Long) objs[0] ); // id
//			tmpEmp.setEmpno( (Integer) objs[1] ); // empno
//			tmpEmp.setEname( (String) objs[2] ); // ename
//			tmpEmp.setJob( (String) objs[3] ); // job
//			tmpEmp.setMgr( (Integer) objs[4] ); // mgr
//			tmpEmp.setHiredate( (String) objs[5] ); // hiredate
//			tmpEmp.setSal( (Integer) objs[6] ); // sal
//			tmpEmp.setComm( (Integer) objs[7] ); // comm
//			tmpEmp.setDeptno( (Integer) objs[8] ); // deptno
//			empList.add(tmpEmp);
//		} // for

		return empList;
	} // findByQueryJob

} // class
