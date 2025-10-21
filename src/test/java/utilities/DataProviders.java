package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
      
	@DataProvider(name ="420")
	public String[][] getData() throws IOException {
		
		String path = ".\\testData\\TC003_Login_TestData.xlsx";
		
		ExelUtility ex = new ExelUtility(path);
		
        int rowscount=ex.GetRowCount("Sheet1");
        int colcount = ex.GetCellCount("Sheet1", 1);
        
        String logindata[][] = new String[rowscount][colcount];// created for two dimension array which can store xl data.
        
        for(int r=1;r<=rowscount;r++) {
        	
        	for(int c=0;c<colcount;c++) {
        		
        	 logindata[r-1][c]= ex.getCellData("Sheet1", r, c);
        	}
        }
        
        return logindata;  
	}

}

// if new DDT is added we should use same data provider class and we should create new data provider method.
//*dataprovider2
  //@DataProvider(name ="name should be different")

///*dataprovider3
//@DataProvider(name ="name should be different")



