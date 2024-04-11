package com.kh.spring17.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	public List<PaymentDto> paymentList() {
		return sqlSession.selectList("payment.paymentList");
	}
	public List<PaymentDetailDto> paymentDetailList(int paymentNo) {
		return sqlSession.selectList("payment.paymentDetailList", paymentNo);
	}
	
	public PaymentDto selectOne(int paymentNo) {
		return sqlSession.selectOne("payment.paymentFind", paymentNo);
	}
	
	public PaymentDetailDto paymentDetailFind(int paymentDetailNo) {
		return sqlSession.selectOne("payment.paymentDetailFind", paymentDetailNo);
	}
	
	public boolean paymentRemainDecrease(int paymentNo, int amount) {
		Map<String, Object> data = new HashMap<>();
		data.put("paymentNo", paymentNo);
		data.put("amount", amount);
		return sqlSession.update("payment.paymentRemainDecrease", data) > 0;
	}
	public boolean paymentDetailCancel(int paymentDetailNo) {
		return sqlSession.update("payment.paymentDetailCancel", paymentDetailNo) > 0;
	}
	public boolean paymentDetailCancelAll(int paymentNo) {
		return sqlSession.update("payment.paymentDetailCancelAll", paymentNo) > 0;
	}

}
