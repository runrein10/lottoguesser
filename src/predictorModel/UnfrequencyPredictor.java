package predictorModel;

import java.util.*;

import lottoCollection.LottoHistory;
import lottoCollection.LottoNumber;

public class UnfrequencyPredictor extends PredictorModel{
//	private LottoHistory LH;
//	private ArrayList<LottoNumber> myPrediction;
//	private Random myRandom = new Random();
//	private int howMany;
//	private int range;
	public UnfrequencyPredictor(LottoHistory LH, int howMany) {
		setLH(LH);
		setHowMany(howMany);
		setRange(35);
		setMyPrediction(generate(getLH(), getHowMany()));
	}
	
	public UnfrequencyPredictor(LottoHistory LH, int howMany, int range) {
		setLH(LH);
		setHowMany(howMany);
		setRange(range);
		setMyPrediction(generate(getLH(), getHowMany()));
	}

	public ArrayList<LottoNumber> generate(LottoHistory LH, int howMany) {
		System.out.println("generating predictions on turn : "+ LH.getPredictTurn());
		
		
		ArrayList<LottoNumber> tempPrediction = new ArrayList<LottoNumber>();
		
		for(int i = 0; i < howMany; i++) {
			Integer[] temp = sortedList(LH.getNumFreq());
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
	
	public Integer[] sortedList(ArrayList<Integer> currFreqArr) {
		Integer[] sorted = new Integer[getRange()];
		ArrayList<Integer> tempSorted = new ArrayList<Integer>();
		
		for(int i = 0; i < sorted.length; i++) {
			int tempLottoNum = getMin(currFreqArr, tempSorted);
			//System.out.println(tempLottoNum);
			sorted[i] = tempLottoNum;
			tempSorted.add(tempLottoNum);
		}
		//System.out.println(getRange() + "개의 최대 freq 숫자 출력 : " + Arrays.toString(sorted));
		return sorted;
	}
	
	public int getMin(ArrayList<Integer> currFreqArr, ArrayList<Integer> tempSorted) {
		int lottoNum = 0;
		int minFreq = currFreqArr.get(1);
		for(int i = 1; i < currFreqArr.size(); i++) {
			int currFreq = currFreqArr.get(i);
			if(currFreq < minFreq && !tempSorted.contains(i)) {
				lottoNum = i;
				minFreq = currFreq;
				//System.out.println(minFreq+ currFreq);
			}
			//System.out.println(""+ minFreq+ currFreq);
		}
		return lottoNum;
	}
	
	public void printOut(ArrayList<LottoNumber> result) {
		for(int i = 0; i < result.size(); i++) {
			
		}
	}

	@Override
	public ArrayList<LottoNumber> generate(LottoHistory LH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<LottoNumber>> generate() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
