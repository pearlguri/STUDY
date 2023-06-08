package co.micol.notice.product.service;

import java.util.List;

public interface ProductMapper {
	//mybatis가 이용하는 VO, 매퍼인터페이스의 구현체가 productmapper.xml
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(ProductVO vo);
}
