package co.micol.notice.product.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductVO {
//	PRODUCT_ID    NOT NULL VARCHAR2(20)   
//	PRODUCT_NAME  NOT NULL VARCHAR2(100)  
//	PRODUCT_IMAGE          VARCHAR2(512)  
//	PRODUCT_DIR            VARCHAR2(1024) 

	private String productId;
	private String productName;
	private String productImage;
	private String productDir;
}
