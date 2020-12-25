import java.util.Vector;

public class itemCollections {
	static Vector<Item> v = new Vector<Item> ();
	static Vector<Item> starV = new Vector<Item>();
	static Vector<Item> nameV = new Vector <Item>();
  	public itemCollections() {
		
	}
	static void addItem(Item i){	//추가하기
		v.add(i);
		for (int k =0;k<v.size();k++) {
			System.out.println("["+k+"]"+v.get(k).getName());
		}
	
	}
	
	static void editItem(String name,Item tempitem) {	//수정하기
		for (int i=0;i<v.size() ; i++) {
			if (v.get(i).getName().equals(name)) {
				int index= v.indexOf(i);
				v.remove(index);
				v.add(index,tempitem);
			}
		}
		
	}
	
	static void deleteItem(String name) {	//삭제하기
		for (int i=0;i<v.size() ; i++) {
			if (v.get(i).getName().equals(name)) {
				int index= v.indexOf(i);
				v.remove(index);
			}
		}
	}
	static Item searchItem(String name) {
		Item t = null;
		
		for (int i=0;i<v.size() ; i++) {
			if (v.get(i).getName().equals(name)) {
				t = v.get(i);
				
			}
		}
		return t;
	
	}
	
	static Vector<Item> searchStarItem(String intstarNumber ) {
		Item t = null;
		for (int i=0;i<v.size();i++) {
			int starNum = v.get(i).getStar();
			if (starNum >= Integer.parseInt(intstarNumber)) {
				t=v.get(i);
				starV.add(t);
			}
		}
		return starV;
		
	}
	static Vector<Item> searchNameItem(String intNameSearch){
		Item t = null;
		for (int i=0;i<v.size();i++) {
			String NameSearch = v.get(i).getName();
			if (NameSearch.contains(intNameSearch)) {
				t= v.get(i);
				nameV.add(t);
			}
		}
		
		return nameV;
		
	}
	static void setV(){
		
	}
	static Vector<Item> getV(){
		return v;
	}
}
