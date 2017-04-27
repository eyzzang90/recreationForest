package com.moneta.pliot.batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.*;
public class MakeJsonForMongo {

	public static void main(String[] args) throws IOException {
		
		
		String path = "C:\\Users\\eyzza\\Desktop\\";
		String fileNm = "ctprvn.xlsx";
		
		//���������� �б�
		File file = new File(path+fileNm);
		System.out.println("file> " + file.getAbsolutePath());
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
		
		int rowindex = 0;
		int columnindex = 0;
		
		
	   	File dir = new File(path);
	   	if( !(dir.exists())){
	   		dir.mkdirs();
	   	}
		
		
		
	   	
		//��Ʈ ��
		XSSFSheet sheet = workbook.getSheetAt(0);		//ù��°���� �����ϹǷ� ��Ʈ�� 0�� �ش�.
		
		//���� ��
		int rows = sheet.getPhysicalNumberOfRows();

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		XSSFRow row = sheet.getRow(2);
		int cells = row.getPhysicalNumberOfCells();		//����� ���� ��
		
		for(rowindex=0; rowindex<rows; rowindex++){
			row = sheet.getRow(rowindex);
			if(row!= null){
				map = new HashMap<String, Object>();
				for(columnindex=0; columnindex<cells; columnindex++){
					XSSFCell cell = row.getCell(columnindex);		//������ �д´�.
					String value = "";
					Integer value2 = null;
					if(cell ==null){		//cell ��üũ
						continue;
					}else{					//Ÿ�Ժ��� ���� �б�
						switch (cell.getCellType()){
						case XSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							value2 = Integer.parseInt(cell.getCellFormula());
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue()+"";
							break;
						case XSSFCell.CELL_TYPE_BLANK:
							value = cell.getStringCellValue()+"";
							break;
						case XSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue()+"";
							break;
						default :
							value = new String();
							break;
						}
					}
					
					if(columnindex==0){
						if(value != null && !value.equals("")){
							map.put("code", value);
						}else{
							System.out.println("?");
							map = null;
							break;
						}
					}else if(columnindex==1){
						if(value != null && !value.equals("")){
							map.put("name", value);
						}else{
							System.out.println("?");
							map = null;
							break;
						}
					}
				}
			}
			if(map != null){
				list.add(map);
			}
		}
	   	
	   	System.out.println("list> " + list.toString());
		
		
		file = new File(path+"ctprvn.json");
		System.out.println(">> " + file.getAbsolutePath());
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(file));
			
			for(int i=0; i<list.size(); i++){
				String code = list.get(i).get("code").toString();
				String name = list.get(i).get("name").toString();
				
				bw.write("{\"code\": \""+code+"\"");
				bw.write(", \"name\": \""+name+"\"}");
				
			}
			
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bw.close();
		}
		
		
		System.out.println("end");
		
		
	}
	
	public void asas(){
		

	}
}
