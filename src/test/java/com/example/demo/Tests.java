package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.times;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Demo.class})
class Tests {

	public Tests() {

	}

	@Test
	public void test1() {
		//Mock static method
		PowerMockito.mockStatic(Demo.class);

		//Set expectation
		Mockito.when(Demo.message()).thenReturn("Anything!");

		//invoke the method
		String message = Demo.message();

		//Assert the stub response
		Assert.assertEquals(message, "Anything!");

		//Verify static method invocation
		PowerMockito.verifyStatic(Demo.class, times(1));
		Demo.message();
	}

}

class Demo {

	public static String message() {
		return "Hi!";
	}

}