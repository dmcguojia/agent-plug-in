/* 
 * ReanExcle.java  
 * 
 * version TODO
 *
 * 2015年12月11日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package cn.com.agent.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
@SuppressWarnings("all")
public class ReadExcle {
    
    public static List<String[]> readXls(File file) throws Exception{
      //创建一个list 用来存储读取的内容
        List<String[]> list = new ArrayList();
        String cell = null;
        //创建输入流
        FileInputStream stream = new FileInputStream(file);
        XSSFWorkbook rwb = new XSSFWorkbook(stream);
        
        //获取Excel文件对象
//        HSSFWorkbook rwb=new HSSFWorkbook(stream);
  
        //获取文件的指定工作表 默认的第一个
        XSSFSheet sheet = rwb.getSheetAt(0);  
//        XSSFSheet sheet = (XSSFSheet) rwb.getSheetAt(0);  
        
        //行数(表头的目录不需要，从1开始)
        for(int i=1; i<=sheet.getLastRowNum(); i++){
         
         //创建一个数组 用来存储每一列的值
         int columns = sheet.getRow(0).getPhysicalNumberOfCells();
         String[] str = new String[columns];
   
         //列数
         
         for(int j=0; j<columns; j++){
         //获取第i行，第j列的值
        	if (sheet.getRow(i).getCell(j) != null) {
        		 cell = sheet.getRow(i).getCell(j).toString();    
                 str[j] = cell;
			}
         }
         //把刚获取的列存入list
         list.add(str);
        }
        stream.close();
        return list;
        }    
    public static List<String[]> readXlsx(File file) throws Exception{
    	//创建一个list 用来存储读取的内容
    	List list = new ArrayList();
    	String cell = null;
    	//创建输入流
    	FileInputStream stream = new FileInputStream(file);
    	//获取Excel文件对象
        HSSFWorkbook rwb=new HSSFWorkbook(stream);
    	
    	//获取文件的指定工作表 默认的第一个
    	HSSFSheet sheet = (HSSFSheet) rwb.getSheetAt(0);  
    	
    	//行数(表头的目录不需要，从1开始)
    	for(int i=1; i<sheet.getLastRowNum(); i++){
    		
    		//创建一个数组 用来存储每一列的值
    		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
    		String[] str = new String[columns];
    		
    		//列数
    		for(int j=0; j<columns; j++){
	         //获取第i行，第j列的值
	        	if (sheet.getRow(i).getCell(j) != null) {
	        		 cell = sheet.getRow(i).getCell(j).toString();    
	                 str[j] = cell;
				}
	         }
    		//把刚获取的列存入list
    		list.add(str);
    	}
    	stream.close();
    	return list;
    }    

//    public String  upload(MultipartFile multipartFile){
//        try {
//            InputStream in=multipartFile.getInputStream();
//            HSSFWorkbook hssfWorkbook=new HSSFWorkbook(in);
//            //循环读取工作表
//           for(int numSheet=0;numSheet<hssfWorkbook.getNumberOfSheets();numSheet++){
//               HSSFSheet hssfSheet=hssfWorkbook.getSheetAt(numSheet);
//               if(hssfSheet==null){
//                   continue;
//               }
//              //循环读取表的每行
//               for(int numRow=0;numRow<=hssfSheet.getLastRowNum();numRow++){
//                   HSSFRow hssfRow=hssfSheet.getRow(numRow);
//                   if(hssfRow!=null){
//                      //封装数据到实体
//                       hssfRow.getCell(0);//第一个单元格对于哪个字段
//                       hssfRow.getCell(1);//第二个
//                       //....
//                       //保存数据库
//                   }
//               }
//           }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
}
