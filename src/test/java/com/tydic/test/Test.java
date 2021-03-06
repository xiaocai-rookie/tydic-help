package com.tydic.test;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import com.tydic.bean.NodeBean;
import com.tydic.service.INodeService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tydic.common.Response;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-base.xml" })
public class Test {
	@Resource
	private INodeService nodeService;

	@org.junit.Test
	public void test() {
		try {
			insertNode();
//			delNode(2);
//			changeToChinese();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void insertNode(){
		NodeBean bean = new NodeBean();
		bean.setContext("##hello");
		bean.setEffective(1);
		bean.setFatherId(126);
		bean.setInsertTime(new Date(System.currentTimeMillis()));
		bean.setUserId(1);
		bean.setUserName("admin");
		Response<Boolean> res = nodeService.insertNode(bean,false);
		System.out.print(res);
	}
	private void delNode(int id){
		nodeService.delNode(id);
	}
	private String changeToChinese(){
		String str = "%E6%97%A0%E6%A0%87%E9%A2%98.png";
		String returnStr="";
		try {
			returnStr = new String(str.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnStr;
	}
}
