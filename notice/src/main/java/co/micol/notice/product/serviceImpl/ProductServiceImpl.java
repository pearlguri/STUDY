package co.micol.notice.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.notice.common.DataSource;
import co.micol.notice.product.service.ProductMapper;
import co.micol.notice.product.service.ProductService;
import co.micol.notice.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //DAO객체 연결
	ProductMapper map = sqlSession.getMapper(ProductMapper.class); //mapper 연결, 모델에서 맵을 통해서 데이터 가져오는 것
	//~impl=>model
	//매퍼에서 디비연결이 sqlsession, 모델은 mapper한테 일을 시킴.
	
	@Override
	public List<ProductVO> productSelectList() {
		return map.productSelectList();
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		return map.productSelect(vo);
	}

	@Override
	public int productInsert(ProductVO vo) {
		return map.productInsert(vo);
	}

	@Override
	public int productUpdate(ProductVO vo) {
		return map.productUpdate(vo);
	}

	@Override
	public int productDelete(ProductVO vo) {
		return map.productDelete(vo);
	}

}
