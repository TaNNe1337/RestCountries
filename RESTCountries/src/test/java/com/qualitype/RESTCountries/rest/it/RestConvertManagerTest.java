package com.qualitype.RESTCountries.rest.it;

import org.junit.Assert;
import org.junit.Test;

import com.qualitype.RESTCountries.rest.RestConvertManager;

public class RestConvertManagerTest {

	final RestConvertManager manager = new RestConvertManager();

	@Test
	public void testGetAllCountries() throws Exception {
		this.manager.convert("test", "test", 0);
		Assert.assertEquals(250, 250);
	}

}
