package com.kosa.mycompany.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("galleryDao")
public class GalleryDaoimpl implements GalleryDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<GalleryDto> getList(GalleryDto dto) {
		return sm.selectList("Gallery_getList", dto); //쿼리 아이디
	}

	@Override
	public int getTotalCnt(GalleryDto dto) {
		return sm.selectOne("Gallery_getTotalCnt", dto);
	}

	@Override
	public void insert(GalleryDto dto) {
		sm.insert("Gallery_insert", dto);
	}

}
