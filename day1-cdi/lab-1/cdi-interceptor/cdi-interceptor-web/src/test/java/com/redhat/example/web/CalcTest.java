package com.redhat.example.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.redhat.example.test.cdi.CDITestRunner;

// スタンドアロンでCDIを有効にするカスタムのRunnerを登録。
// 注意：Java SE環境ではbeans.xmlは省略できないため、モジュール毎(クラスパス毎)にbeans.xmlを配置すること
@RunWith(CDITestRunner.class)
public class CalcTest {

	@Inject Calc calc;

	@Test
	public void testAdd() {
		assertThat(calc, is(notNullValue()));
		assertThat(calc.add(10, 20), is(30));
	}

}
