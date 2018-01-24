package predictorModel;

import java.util.ArrayList;
import java.util.Random;

import lottoCollection.*;

public abstract class PredictorModel implements IPredictor {
	
	private LottoHistory LH;
	private ArrayList<LottoNumber> myPrediction;
	private Random myRandom = new Random();
	private int howMany;
	private int range;
	private int from;
	private int to;
	
	
	public ArrayList<LottoNumber> getMyPrediction() {
		return myPrediction;
	}
	public void setMyPrediction(ArrayList<LottoNumber> myPrediction) {
		this.myPrediction = myPrediction;
	}
	public int getHowMany() {
		return howMany;
	}
	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}
	public Random getMyRandom() {
		return myRandom;
	}
	public void setMyRandom(Random myRandom) {
		this.myRandom = myRandom;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public LottoHistory getLH() {
		return LH;
	}
	public void setLH(LottoHistory lH) {
		LH = lH;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}
}
