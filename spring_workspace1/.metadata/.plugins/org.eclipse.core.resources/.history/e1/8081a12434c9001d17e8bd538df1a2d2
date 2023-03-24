package com.ds.damin.mall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ds.damin.common.Criteria;

@Service("mallService")
public class MallServiceimpl implements MallService{
	
	@Resource(name="mallDao")
	MallDao dao;

	@Override
	public List<MallDto> getList(MallDto dto) {
		return dao.getList(dto);
	}

	@Override
	public MallDto getView(MallDto dto) {
		return dao.getView(dto);
	}

	@Override
	public void insert(MallDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(MallDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(MallDto dto) {
		dao.delete(dto);
	}


	@Override
	public List<MallDto> getListPaging(Criteria cri) {
		if(cri.getNum().equals("1"))
			return dao.getListPaging(cri);
		else if(cri.getNum().equals("2"))
			return dao.H_L_getList(cri);
		else
			return dao.L_H_getList(cri);
	}
	
	@Override
	public int getTotal() {
		return dao.getTotal();
	}


}
