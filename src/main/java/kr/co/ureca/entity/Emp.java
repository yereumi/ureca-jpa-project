package kr.co.ureca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emp")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "empno")
	private Integer empno;

	@Column(name = "ename")
	private String ename;

	@Column(name = "job")
	private String job;

	@Column(name = "mgr")
	private Integer mgr;

	@Column(name = "hiredate")
	private String hiredate;

	@Column(name = "sal")
	private Integer sal;

	@Column(name = "comm")
	private Integer comm;

	@Column(name = "deptno")
	private Integer deptno;

} // class














