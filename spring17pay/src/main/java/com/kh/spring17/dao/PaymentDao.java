package com.kh.spring17.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring17.dto.PaymentDetailDto;
import com.kh.spring17.dto.PaymentDto;

@Repository
public class PaymentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int paymentSequence() {
		return sqlSession.selectOne("payment.paymentSequence");
	}
	
	public void insertPayment(PaymentDto paymentDto) {
		sqlSession.insert("payment.paymentAdd", paymentDto);
	}
	
	public int paymentDetailSequence() {
		return sqlSession.selectOne("payment.paymentDetailSequence");
	}
	
	public void insertPaymentDetail(PaymentDetailDto paymentDetailDto) {
		sqlSession.insert("payment.paymentDetailAdd", paymentDetailDto);
	}

}
