package Tests;

import org.testng.annotations.Test;

import Pages.Drag_Drop_Page;

public class DragAndDropTC extends TestBase{

	@Test
	public void DragAndDrop_Function() {
		
		Drag_Drop_Page dd=new Drag_Drop_Page(driver);
		dd.DragAndDrop();
		
	}
	
}
