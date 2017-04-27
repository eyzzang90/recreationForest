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

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.*;
public class MakeJsonForMongo2 {

	public static void main(String[] args) throws IOException {
		
		
		String path = "C:\\Users\\eyzza\\Desktop\\";
		String fileNm = "recreationForest.xlsx";
		
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
							value = NumberToTextConverter.toText(cell.getNumericCellValue())+"";
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
							map.put("name", value);
						}else{
							System.out.println("0");
							map = null;
							break;
						}
					}else if(columnindex==1){
						if(value != null && !value.equals("")){
							map.put("type", value);
						}else{
							System.out.println("1");
							map = null;
							break;
						}
					}else if(columnindex==2){
						if(value != null && !value.equals("")){
							map.put("area", value);
						}else{
							System.out.println("2");
							map = null;
							break;
						}
					}else if(columnindex==3){
						if(value != null && !value.equals("")){
							map.put("cpcty", value);
						}else{
							System.out.println("3");
//							map = null;
							map.put("cpcty", "");
//							break;
						}
					}else if(columnindex==4){
						if(value != null && !value.equals("")){
							map.put("stayingYn", value);
						}else{
							System.out.println("4");
							map = null;
							break;
						}
					}else if(columnindex==5){
						if(value != null && !value.equals("")){
							map.put("addr", value);
						}else{
							System.out.println("5");
							map = null;
							break;
						}
					}else if(columnindex==6){
						if(value != null && !value.equals("")){
							map.put("orgnName", value);
						}else{
							System.out.println("6");
							map = null;
							break;
						}
					}else if(columnindex==7){
						if(value != null && !value.equals("")){
							map.put("siteUrl", value);
						}else{
							map.put("siteUrl", "");
//							break;
						}
					}else if(columnindex==8){
						if(value != null && !value.equals("")){
							map.put("la", value);
						}else{
							map = null;
							break;
						}
					}else if(columnindex==9){
						if(value != null && !value.equals("")){
							map.put("lo", value);
						}else{
							map = null;
							break;
						}
					}else if(columnindex==10){
						if(value != null && !value.equals("")){
							map.put("baseDt", value);
						}else{
							map = null;
							break;
						}
					}else if(columnindex==11){
						if(value != null && !value.equals("")){
							map.put("cpCode", value);
						}else{
							map = null;
							break;
						}
					}else if(columnindex==12){
						if(value != null && !value.equals("")){
							map.put("rcrFrstId", value);
						}else{
							map = null;
							break;
						}
					}else if(columnindex==13){
						if(value != null && !value.equals("")){
							map.put("tel1", value);
						}else{
							map = null;
							break;
						}
					}else if(columnindex==14){
						if(value != null && !value.equals("")){
							map.put("tel2", value);
						}else{
							map = null;
							break;
						}
					}else if(columnindex==15){
						if(value != null && !value.equals("")){
							map.put("tel3", value);
						}else{
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
		
		
		file = new File(path+"recreationForest.json");
		System.out.println(">> " + file.getAbsolutePath());
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(file));
			
			for(int i=0; i<list.size(); i++){
				String rcrFrstId = list.get(i).get("rcrFrstId").toString();
				String name = list.get(i).get("name").toString();
				String type = list.get(i).get("type").toString();
				String area = list.get(i).get("area").toString();
				String cpcty = list.get(i).get("cpcty").toString();
				String stayingYn = list.get(i).get("stayingYn").toString();
				String addr = list.get(i).get("addr").toString();
				String tel1 = list.get(i).get("tel1").toString();
				String tel2 = list.get(i).get("tel2").toString();
				String tel3 = list.get(i).get("tel3").toString();
				String siteUrl = list.get(i).get("siteUrl").toString();
				String la = list.get(i).get("la").toString();
				String lo = list.get(i).get("lo").toString();
				String orgnName = list.get(i).get("orgnName").toString();
				String baseDt = list.get(i).get("baseDt").toString();
				String cpCode = list.get(i).get("cpCode").toString();
				
				bw.write("{\"_id\": NumberLong("+rcrFrstId+")");
				bw.write(", \"cpCode\": \""+cpCode+"\"");
				bw.write(", \"name\": \""+name+"\"");
				bw.write(", \"type\": \""+type+"\"");
				bw.write(", \"area\": \""+area+"\"");
				bw.write(", \"cpcty\": \""+cpcty+"\"");
				bw.write(", \"stayingYn\": \""+stayingYn+"\"");
				bw.write(", \"addr\": \""+addr+"\"");
				bw.write(", \"tel1\": \""+tel1+"\"");
				bw.write(", \"tel2\": \""+tel2+"\"");
				bw.write(", \"tel3\": \""+tel3+"\"");
				bw.write(", \"siteUrl\": \""+siteUrl+"\"");
				bw.write(", \"la\": \""+la+"\"");
				bw.write(", \"lo\": \""+lo+"\"");
				bw.write(", \"orgnName\": \""+orgnName+"\"");
				bw.write(", \"area\": \""+area+"\"");
				bw.write(", \"baseDt\": \""+baseDt+"\"}");
				
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
