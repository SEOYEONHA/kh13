package com.kh.spring17.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring17.dto.ProductDto;

@Repository
public class ProductDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ProductDto> selectList(){
		return sqlSession.selectList("product.list");
	}
	
	public ProductDto selectOne(int no) {
		return sqlSession.selectOne("product.find", no);
	}
}
