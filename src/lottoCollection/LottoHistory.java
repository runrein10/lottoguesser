package lottoCollection;
import java.util.ArrayList;
import edu.duke.*;


public class LottoHistory {
	private ArrayList<LottoNumber> myHis;
	private ArrayList<Integer> numFreq;
	private ArrayList<Integer> numBonusFreq;
	private int predictTurn;

	
	public LottoHistory(FileResource f) {
		System.out.println("constructor for all lotto results...");
		myHis = setMyHis(f);
		numFreq = setNumFreq(myHis);
		numBonusFreq = setNumBonusFreq(myHis);
	}
	
	public LottoHistory(FileResource f, int turn) {
		System.out.println("constructing"+(turn-1)+"turn history...");
		predictTurn = turn;
		myHis = setMyHis(f, predictTurn);
		numFreq = setNumFreq(myHis);
		numBonusFreq = setNumBonusFreq(myHis);
	}
	
	public void setPredictTurn(int turn) {
		predictTurn = turn;
	}
	
	public int getPredictTurn() {
		return predictTurn;
	}
	
	public void printOut() {
		System.out.println("printout method...");
		for (int i = 0; i<myHis.size(); i++) {
			LottoNumber tempLN = myHis.get(i);
			tempLN.printOut();
		}
	}
	
	public void printFreq() {
		System.out.println("printout freq...");
		for(int i = 0; i < numFreq.size(); i++) {
			System.out.println(i + ", " + numFreq.get(i));
		}
	}
	
	
	public ArrayList<LottoNumber> getMyHis() {
		return myHis;
	}
	
	public ArrayList<LottoNumber> setMyHis(FileResource f) {
		ArrayList<LottoNumber> tempHis = new ArrayList<LottoNumber>();
		//add a default LN to tempHis.get(0)
		LottoNumber templn = new LottoNumber(0);
		templn.ReadCSV("0,0000,0,0,0,0,0,0,0");
		tempHis.add(templn);
		int turn = 1;
		for(String line : f.lines()) {
			templn = new LottoNumber(turn);
			templn.ReadCSV(line);
			tempHis.add(templn);
			turn += 1;
		}
		return tempHis;
	}
	
	public ArrayList<LottoNumber> setMyHis(FileResource f, int preTurn) {
		ArrayList<LottoNumber> tempHis = new ArrayList<LottoNumber>();
		//add a default LN to tempHis.get(0)
		LottoNumber templn = new LottoNumber(0);
		templn.ReadCSV("0,0000,0,0,0,0,0,0,0");
		tempHis.add(templn);
		int turn = 1;
		for(String line : f.lines()) {
			templn = new LottoNumber(turn);
			templn.ReadCSV(line);
			tempHis.add(templn);
			if(turn >= preTurn) {
				System.out.println("breaking while setting my history for turn : "+preTurn);
				break;
			}
			turn += 1;
		}
		return tempHis;
	}
	
	public Integer getNumFreq(int num) {
		return numFreq.get(num);
	}
	
	public ArrayList<Integer> getNumFreq() {
		return numFreq;
	}

	public ArrayList<Integer> setNumFreq(ArrayList<LottoNumber> input) {
		ArrayList<Integer> tempNumFreq = new ArrayList<Integer>();
		for(int k = 0; k < 46; k++) {
			tempNumFreq.add(0);
		}
		for(int i = 1; i<input.size()-1; i++) {
			LottoNumber tempLN = input.get(i);
			for(int j = 0; j < tempLN.getMyNum().size(); j++) {
				int currNum = tempLN.getMyNum().get(j);
				tempNumFreq.set(currNum, tempNumFreq.get(currNum)+1);
			}
		}
		return tempNumFreq;
	}
	
	public ArrayList<Integer> setNumFreqbyTurn(ArrayList<LottoNumber> input, int turn) {
		ArrayList<Integer> tempNumFreq = new ArrayList<Integer>();
		for(int k = 0; k < 46; k++) {
			tempNumFreq.add(0);
		}
		for(int i = 1; i<turn; i++) {
			LottoNumber tempLN = input.get(i);
			for(int j = 0; j < tempLN.getMyNum().size(); j++) {
				int currNum = tempLN.getMyNum().get(j);
				tempNumFreq.set(currNum, tempNumFreq.get(currNum)+1);
			}
		}
		return tempNumFreq;
	}

	public ArrayList<Integer> getNumBonusFreq() {
		return numBonusFreq;
	}

	public ArrayList<Integer> setNumBonusFreq(ArrayList<LottoNumber> input) {
		ArrayList<Integer> tempNumBonusFreq = new ArrayList<Integer>();
		for(int k = 0; k < 46; k++) {
			tempNumBonusFreq.add(0);
		}
		for(int i = 1; i<input.size(); i++) {
			LottoNumber tempLN = input.get(i);
			int currBonusNum = tempLN.getBonusNum();
			tempNumBonusFreq.set(currBonusNum, tempNumBonusFreq.get(currBonusNum)+1);
			}
		return tempNumBonusFreq;
	}
}
