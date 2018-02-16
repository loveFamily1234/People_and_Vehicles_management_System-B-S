package 业务逻辑层;
 
import com.opensymphony.xwork2.ActionSupport;  
import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.struts2.interceptor.ServletRequestAware;  
import org.apache.struts2.interceptor.ServletResponseAware;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import 数据服务层.*;
  
public class CarOutputExcelAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{  
    protected HttpServletRequest request = null;  
    protected HttpServletResponse response = null;  
    public void setServletRequest(HttpServletRequest arg0) {  
        this.request = arg0;  
    }  
    public void setServletResponse(HttpServletResponse arg0) {  
        this.response = arg0;  
    }  
    //获取输出流  
    public InputStream getInputExcel()  
    {  
        return (InputStream)request.getAttribute("excelStream");  
    }  
    @Override  
    public String execute() throws Exception {
		ConnectDatabase con = new ConnectDatabase();
		String sql = "SELECT * from 来访车辆";
		PreparedStatement ps = ConnectDatabase.dbconn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	
		int rows=0;  
        HSSFWorkbook wk = new HSSFWorkbook();  
        HSSFSheet sheet = wk.createSheet("FollowAgentStats");  
        HSSFRow row = sheet.createRow(rows++);  
        int column=0;  
        HSSFCell cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
        cell.setCellValue("卡号");  
        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
        cell.setCellValue("车牌号");
        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
        cell.setCellValue("事由"); 
        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
        cell.setCellValue("入校时间"); 
        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
        cell.setCellValue("离校时间"); 
        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
        cell.setCellValue("计费"); 
        while(rs.next()){
        	 
	        row = sheet.createRow(rows++);  
	        column=0;  
	        cell = row.createCell(column++,HSSFCell.CELL_TYPE_NUMERIC);  
	        cell.setCellValue(rs.getString(1));  
	        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
	        cell.setCellValue(rs.getString(2)); 
	        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
	        cell.setCellValue(rs.getString(3));
	        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
	        cell.setCellValue(rs.getString(4));
	        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
	        cell.setCellValue(rs.getString(5));
	        cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);  
	        cell.setCellValue(rs.getString(6));
           
        }  
        try{  
            ByteArrayOutputStream out=new ByteArrayOutputStream();  
            wk.write(out);  
            request.setAttribute("excelStream",new ByteArrayInputStream(out.toByteArray()));  
            request.setAttribute("filename", "car.xls");//设置文件名  
            return SUCCESS;  
        }catch(Throwable th){  
            th.printStackTrace();  
            System.out.println("无法输出Excel文件");  
            return ERROR;  
        }     
    }  
}  