package co.micol.notice.product.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.notice.common.Command;
import co.micol.notice.product.service.ProductService;
import co.micol.notice.product.service.ProductVO;
import co.micol.notice.product.serviceImpl.ProductServiceImpl;

public class ProductInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 제품등록 처리 및 파일업로드
		ProductService ps = new ProductServiceImpl();
		ProductVO vo = new ProductVO();

		String saveDir = "upload/";
		int maxSize = 100 * 1024 * 1024;

		try {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			String pfile = multi.getFilesystemName("pfile"); // getfilesystemname하는 순간 메모리에 있던 file이 물리적 경로로 저장되는것.
			pfile = saveDir + pfile; // 물리적 저장위치. 나중에 다운로드 받을때 필요
			String ofile = multi.getOriginalFileName("pfile"); // form의 file input에서 지정했던 name을 그대로 쓰는 것

			vo.setProductId(multi.getParameter("productId")); // try catch 안에서 읽으려면 vo. 말고 multi. 으로 해야함. vo로하면 null뜸.
			vo.setProductName(multi.getParameter("productName"));
			if (ofile != null) {
				vo.setProductImage(ofile);
				vo.setProductDir(pfile);
			}
			ps.productInsert(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "productList.do";
	}

}
