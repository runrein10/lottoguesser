package lottoCollection;

import java.util.ArrayList;

public class Result {
	
	private int turn;
	private int from;
	private int to;
	private String predictorName;
	//only when From~To is not signed
	private ArrayList<LottoNumber> predictedLottoNumber;
	//howMany are predicted
	private int predictedNumber;
	//idx0:0 idx1:1st idx:2nd 
	private int[] matchResults;
	private int matchAll;
	
	
	public Result() {
		predictorName = "";
		predictedLottoNumber = new ArrayList<LottoNumber>();
		
	}
	
}
