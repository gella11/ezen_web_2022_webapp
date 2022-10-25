package model.dao;

import java.util.ArrayList;

import model.dto.PcategoryDto;
import model.dto.ProductDto;


public class ProductDao extends Dao{
	
	// 1. 카테고리 등록
	public boolean setpcategory(String pcname) {
		String sql = "insert into pcategory(pcname) value(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pcname);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);	}
		return false;
	}
	
	// 2. 카테고리 출력
	public ArrayList<PcategoryDto> getpcatogory(){
		ArrayList<PcategoryDto> list = new ArrayList<>();
		String sql = "select * from pcategory";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				PcategoryDto dto = new PcategoryDto(
						rs.getInt(1),
						rs.getString( 2 )					
						);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {	System.out.println(e);	}
		return null;
	}

	// 3. 제품등록
	public boolean setproduct(ProductDto dto) {
		return false;
	}
	
	// 4. 제품 출력
	public ArrayList<ProductDto > getProductlist(){
		return null;
	}
	
	
	
}
