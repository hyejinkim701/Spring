package vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("vo")
public class MemberVO {
	private String id ;
	private String password ;
	private String name ;
	private String lev ;
	private int pay ;
	private String birthd ;
	private double weight ;
	private String uploadfile; //member table에 정의된  field 형
	private MultipartFile uploadfilef; 

	//form 으로부터 읽어오기 위한 filenname 필드
	/* => MultipartFile Type 은 UpLoad 된 파일을 전송받기 위해 필요한 타입이며
	  	서버의 지정된 위치에 image를 보관하고
	  	실제DB에는 경로와 화일명이 String Type으로보관 됨,
	  	그러므로 이에대한처리가 필요함 
	 	=>별도의 String Type uploadfile 필드 추가 하여 사용함
	 */
	
	public MultipartFile getUploadfilef() {
		return uploadfilef;
	}
	public void setUploadfilef(MultipartFile uploadfilef) {
		this.uploadfilef = uploadfilef;
	}
	
	public String getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getBirthd() {
		return birthd;
	}
	public void setBirthd(String birthd) {
		this.birthd = birthd;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", lev=" + lev + ", pay=" + pay
				+ ", birthd=" + birthd + ", weight=" + weight + ", uploadfile=" + uploadfile + ", uploadfilef="
				+ uploadfilef + "]";
	}
} // class
