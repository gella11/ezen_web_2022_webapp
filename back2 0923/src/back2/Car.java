package back2;


public class Car {

	// 1. 필드
	int gas;
	// 2. 생성자
	// 3. 매소드
	void setGas(int gas) {
		this.gas = gas;
		return;
	}
	
	boolean isLeftGas() {
		if(gas==0) {
		System.out.println("gas가 없습니다.");
		return false;
	}
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("달립니다.(gas잔량:" + gas + ")");
				gas -= 1;
			}else {
				System.out.println("멈춥니다.(gas잔량:" + gas + ")");
				return;
			}
		}
	}
}
