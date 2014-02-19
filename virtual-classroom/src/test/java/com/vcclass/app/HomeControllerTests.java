package com.vcclass.app;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

public class HomeControllerTests {
	
	@Test
	public void HandleRequestViewTest()
	{
		HomeController controller = new HomeController();
		Locale locale = new Locale("en-us"); 
		
        String result = controller.home(locale, new ExtendedModelMap());
        String expected = "home"; 
        assertEquals(result, expected);
	}

}
