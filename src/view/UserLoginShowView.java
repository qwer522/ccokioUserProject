package view;



import domain.User;

public class UserLoginShowView {
	
	
	
	public UserLoginShowView() {

		
		
	}
	
	public void userLoginInfoView(User searchedUser){
		
		System.out.println("\n\t [*]  내        정        보      [*]");
		System.out.println("이름\t전화번호\t주소\t등급\t쿠폰\t구매량");
		
		System.out.print(searchedUser.getUserName() + "\t");
		System.out.print(searchedUser.getUserTel()+ "\t");
		System.out.print(searchedUser.getUserAddress()+ "\t");
		System.out.print(searchedUser.getUserClass()+ "\t");
		System.out.print(searchedUser.getCoupon()+ "\t");
		System.out.println(searchedUser.getPurchaseQuantity());
		
		
		
	}
	
	

}
