package kr.co.ureca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.co.ureca.entity.Emp;

public interface EmpRepository extends CrudRepository<Emp, Long> {

	public List<Emp> findAll();

	public Emp findByEname(String ename);

	public Emp findByEnameAndSal(String ename, Integer sal);

	public Emp findByEnameAndJobAndSal(String ename, String job, Integer sal);

	public List<Emp> findByEnameOrJobOrSal(String ename, String job, Integer sal);

	public List<Emp> findByJobLike(String job);

	public List<Emp> findByJobOrderByDeptnoDescEnameAsc(String job);

	public List<Emp> findBySalLessThan(Integer sal);

	public List<Emp> findBySalLessThanEqual(Integer sal);

	public List<Emp> findBySalGreaterThan(Integer sal);

	public List<Emp> findBySalGreaterThanEqual(Integer sal);

	@Query("select e FROM Emp e WHERE e.ename = ?1")
	public Emp findByQueryEname(String ename); // 개발자가 임의로 정의한 메소드.

	@Query("select e FROM Emp e WHERE e.ename = :name")
	public Emp findByQueryEnameParam(@Param("name") String ename); // 개발자가 임의로 정의한 메소드.

	// 속성을 List하면 하나의 row는 Object[]로 return된다.
	@Query("SELECT e.id, e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno"
			+ " FROM Emp e WHERE e.job = ?1")
	public List<Object[]> findByQueryJob(String job); // 개발자가 임의로 정의한 메소드.

	@Query("SELECT e FROM Emp e WHERE e.job = :jobName")
	public List<Emp> findByQueryJobParam(@Param("jobName") String job); // 개발자가 임의로 정의한 메소드.

} // interface









