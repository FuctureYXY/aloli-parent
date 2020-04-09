package com.aloli.service;

import com.aloli.util.AloliEmail;
import com.aloli.util.AloliUtils;

public class Test {

	public static void main(String[] args) {
		AloliEmail aloliEmail = new AloliEmail();

		aloliEmail.send(aloliEmail.sender(),"610717592@qq.com",AloliUtils.getNumSmallCharRandom(4));

    } 

}
