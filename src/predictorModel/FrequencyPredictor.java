package predictorModel;

import java.util.*;
import lottoCollection.*;

public class FrequencyPredictor extends PredictorModel{
//	private LottoHistory LH;
//	private ArrayList<LottoNumber> myPrediction;
//	private Random myRandom = new Random();
//	private int howMany;
//	private int range;
//	private int from;
//	private int to;
	
	private ArrayList<Integer> numFreq;
	public ArrayList<ArrayList<Integer>> numFreqArr;
	
	public FrequencyPredictor(LottoHistory LH, int howMany) {
		setLH(LH);
		setHowMany(howMany);
		setRange(10);
		setMyPrediction(generate(getLH()));
	}
	
	public FrequencyPredictor(LottoHistory LH, int howMany, int range) {
		setLH(LH);
		setHowMany(howMany);
		setRange(range);
		setMyPrediction(generate(getLH()));
	}
		
	//Constructor for MainRunner
	public FrequencyPredictor(LottoHistory LH, int from, int to, int range, int howMany) {
		setLH(LH);
		setHowMany(howMany);
		setRange(range);
		setFrom(from);
		setTo(to);
		for (int i = (from); i<(to+1); i++) {
			numFreqArr.add(setNumFreq(i));
		}
	}

	//Constructor for MainRunner
	public ArrayList<ArrayList<LottoNumber>> generate(){
		System.out.println("generating predictions on turn : "+ getLH().getPredictTurn());
		ArrayList<ArrayList<LottoNumber>> tempPrediction = new ArrayList<ArrayList<LottoNumber>>();
		
//		if(getFrom()==0 || getTo()==0) {
//			int turn = getFrom()+getTo();
//			
//		}
		int j = 0;
		for(int i = getFrom(); i < this.getHowMany(); i++) {
			Integer[] temp = sortList(numFreqArr.get(j));
			LottoNumber picked = pickSorted(temp);
			tempPrediction.add(picked);
			j += 1;
		}
		
		return tempPrediction;
	}
	
	public ArrayList<LottoNumber> generate(LottoHistory LH) {
		System.out.println("generating predictions on turn : "+ LH.getPredictTurn());
		
		
		ArrayList<LottoNumber> tempPrediction = new ArrayList<LottoNumber>();
		
		for(int i = 0; i < this.getHowMany(); i++) {
			Integer[] temp = sortList(LH.getNumFreq());
			//System.out.println(LH.getNumFreq());
			//System.out.println(Arrays.toString(temp));
			LottoNumber picked = pickSorted(temp);
			tempPrediction.add(picked);
		}
		return tempPrediction;
	}
	
	public LottoNumber pickSorted(Integer[] input) {
		Integer[] sorted = input;
		LottoNumber picked = new LottoNumber();
		ArrayList<Integer> pickedArr = new ArrayList<Integer>();
		while(pickedArr.size() < 6) {
			int tempNum = sorted[getMyRandom().nextInt(sorted.length)];
			if(!pickedArr.contains(tempNum)) {
				pickedArr.add(tempNum);
			}
		}
		
		picked.ReadArray(pickedArr.toString());
		return picked;
	}
	
	public Integer[] sortList(ArrayList<Integer> currFreqArr) {
		Integer[] sorted = new Integer[getRange()];
		ArrayList<Integer> tempSorted = new ArrayList<Integer>();
		
		for(int i = 0; i < sorted.length; i++) {
			int tempLottoNum = getMax(currFreqArr, tempSorted);
			//System.out.println(tempLottoNum);
			sorted[i] = tempLottoNum;
			tempSorted.add(tempLottoNum);
		}
		//System.out.println(getRange() + "개의 최대 freq 숫자 출력 : " + Arrays.toString(sorted));
		return sorted;
	}
	
	public int getMax(ArrayList<Integer> currFreqArr, ArrayList<Integer> tempSorted) {
		int lottoNum = 0;
		int maxFreq = 0;
		for(int i = 0; i < currFreqArr.size(); i++) {
			int currFreq = currFreqArr.get(i);
			if(currFreq > maxFreq && !tempSorted.contains(i)) {
				lottoNum = i;
				maxFreq = currFreq;
			}
		}
		return lottoNum;
	}
	
	public void printOut(ArrayList<LottoNumber> result) {
		for(int i = 0; i < result.size(); i++) {
			
		}
	}
	private ArrayList<Integer> setNumFreq(int to) {
		ArrayList<Integer> tempNumFreq = new ArrayList<Integer>();
		for(int k = 0; k < 46; k++) {
			tempNumFreq.add(0);
		}
		for(int i = 1; i<to; i++) {
			LottoNumber tempLN = getLH().getMyHis().get(i);
			for(int j = 0; j < tempLN.getMyNum().size(); j++) {
				int currNum = tempLN.getMyNum().get(j);
				tempNumFreq.set(currNum, tempNumFreq.get(currNum)+1);
			}
		}
		this.numFreq = tempNumFreq;
		return tempNumFreq;
	}
}
