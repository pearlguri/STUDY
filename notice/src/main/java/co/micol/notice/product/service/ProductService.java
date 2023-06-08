package co.micol.notice.product.service;

import java.util.List;

public interface ProductService {
	//DAO 자바 모델이 쓰는것, 이것의 구현체가 serviceimpl
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(ProductVO vo);
}
