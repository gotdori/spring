package com.kosa.mycompany.gallery;

import java.util.List;

public interface GalleryDao {
	List<GalleryDto> getList(GalleryDto dto);
	int getTotalCnt(GalleryDto dto);
	void insert(GalleryDto dto);
	
}
