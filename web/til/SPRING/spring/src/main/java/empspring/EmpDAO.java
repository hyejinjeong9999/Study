package empspring;

public class EmpDAO {
	EmpVO vo;

	public void setVo(EmpVO vo) {
		this.vo = vo;
	}

	public void insertEmp() {
//EmpVO 객체 1개 생성(김사원 10000 교육부)
		
		System.out.println(vo.getName()+"사원은"+vo.getSalary()+"금액을받고"+vo.getDeptname());
      
		
	}
}
