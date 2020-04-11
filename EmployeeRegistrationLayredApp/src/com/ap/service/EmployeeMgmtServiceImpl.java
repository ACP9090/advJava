package com.ap.service;

import com.ap.BO.EmployeeBo;
import com.ap.DAO.EmployeeDao;
import com.ap.DAO.EmployeeDaoImpl;
import com.ap.DTO.EmployeeDto;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
    private EmployeeDao dao;
    public EmployeeMgmtServiceImpl()
    {
      dao=new EmployeeDaoImpl();
    }
	
	@Override
	public String registerEmployee(EmployeeDto dto) throws Exception {
		float gSal=0.0f;
		float nSal=0.0f;
		EmployeeBo bo=null;
		int count=0;
		//write business logic
		gSal=dto.getbSal()+(dto.getbSal()*0.4f);
		nSal=gSal-(gSal*0.2f);
		
		//set into bo class object
		bo=new EmployeeBo();
		bo.seteName(dto.geteName());
		bo.seteAddress(dto.getEAddress());
		bo.setDoj(dto.getDoj());
		bo.setbSal(dto.getbSal());
		bo.setgSal(gSal);
		bo.setnSal(nSal);
		
		count=dao.insert(bo);
		if(count==0)
		{
			return "registration failed";
		}
		else
		{
			return "registration succed";
		}

	}

}
