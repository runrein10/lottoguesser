/**
 * 
 */
/**
 * @author MinSKim
 *
 */
package lottoCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LottoNumber {
	private ArrayList<Integer> myNum;
	private int bonusNum;
	//if turnNum 0 => default lotto num.
	private int turnNum;
	private String turnDate;
	//if it's a prediction = 1/ result = 0
	private int status;
	
	//Initializer for results by param turn number.
	public LottoNumber(int num) {
		setMyNum(new ArrayList<Integer>());
		setTurnNum(num);
		setStatus(0);
	}
	
	public LottoNumber() {
		setMyNum(new ArrayList<Integer>());
		setStatus(1);
	}
	
	public void printOut() {
		if(getTurnNum()==0) {
			System.out.println("예상번호 : " + 
					getMyNum().toString() +"/ 보너스번호 : " + getBonusNum());
		}
		else {
			System.out.println(getTurnNum() + "회차 당첨번호 : " + 
					getMyNum().toString() +"/ 보너스번호 : " + getBonusNum());
		}
	}
	
	public void ReadCSV(String line) {
		String[] tempArr = line.split(",");
		setTurnNum(Integer.parseInt(tempArr[0]));
		setTurnDate(tempArr[1]);
		for(int i = 2; i <= 7; i++) {
			setMyNum(Integer.parseInt(tempArr[i]));
			//System.out.println("added '" + tempArr[i] + "' to " + turnNum+"회차");
		}
		setBonusNum(Integer.parseInt(tempArr[8]));
	}
	
	public void ReadArray(String line) {
		line = line.substring(1,(line.length()-1));
		String[] tempArr = line.split(", ");
		//System.out.println(Arrays.toString(tempArr));
		for(int i = 0; i < tempArr.length; i++) {
			setMyNum(Integer.parseInt(tempArr[i]));
			//System.out.println("added '" + tempArr[i] + "' to " + turnNum+"회차");
		}
	}
	
	public boolean contains() {
		//
		return false;
	}
	
	public int comparePlace(LottoNumber result) {
		// 0 = nothing matches
		// 1 = 1st
		// 2 = 2nd
		// 3 = 3rd
		// 4 = 4th
		// 5 = 5th place
		int temp = compareMatched(result);
		if(temp < 3) return 0;
		if(temp == 3) return 5;
		if(temp == 4) return 4;
		if(temp == 5) {
			if(bonusNum == result.getBonusNum()) {
				return 2;
			}
			return 3;
		}
		if(temp == 6) return 1;
		return 0;
	}
	
	public int compareMatched(LottoNumber result) {
		int matchCount = 0;
		for(int i = 0; i < result.getMyNum().size(); i++) {
			if(myNum.contains(result.getMyNum().get(i))){
//				System.out.println("예상번호" + result.getMyNum());
//				System.out.println("당첨번호" + getMyNum());
//				System.out.println("match found!!!!  : " + result.getMyNum().get(i));
				matchCount += 1;
			}
		}
		return matchCount;
	}
	
	//getter and setters
//	public void setRandom (int seed) {
//		myRandom = new Random(seed);
//	}
	
	//for MyNumbers
	public ArrayList<Integer> getMyNum() {
		return myNum;
	}
	public void setMyNum(int num) {
		myNum.add(num);
	}
	
	public void setMyNum(ArrayList<Integer> arrNum) {
		myNum = arrNum;
	}
	
	//for TurnNum
	public int getTurnNum() {
		return turnNum;
	}
	public void setTurnNum(int turnNum) {
		this.turnNum = turnNum;
	}

	
	//for Status
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getTurnDate() {
		return turnDate;
	}

	public void setTurnDate(String turnDate) {
		this.turnDate = turnDate;
	}

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}
}