package lottoCollection;

import java.util.ArrayList;

public class Compare {

	private int matchCountAll;
	
	public Integer[] compare(ArrayList<LottoNumber> prediction, LottoNumber resultInTurn) {
		Integer[] r = {0,0,0,0,0,0,0};
		for(int i = 0; i < prediction.size(); i++) {
			int tempResult = resultInTurn.comparePlace(prediction.get(i));
			r[tempResult] += 1;
			matchCountAll += resultInTurn.compareMatched(prediction.get(i));
		}
		int allR = r[0]+r[1]+r[2]+r[3]+r[4]+r[5]+r[6];
		double[] rp = {1,1,1,1,1,1,1};
		for(int i = 0; i < rp.length; i++) {
			if(r[i]!=0) {
				rp[i] = allR/r[i];
			}
			else{
				rp[i] = 0;
			}
		}
		r[6] = matchCountAll;
		System.out.println("------------------------------------------");
		System.out.println("compared " + prediction.size()+" numbers");
		System.out.println("matched number : " + r[6]);
		System.out.println("1등 : "+r[1]+", 2등 : "+r[2]+", 3등 : "+r[3]+
				", 4등 : "+r[4]+", 5등 : "+r[5]+"  미당첨 : "+r[0]);
		System.out.println("1등 : 1/"+rp[1]+", 2등 : 1/"+rp[2]+", 3등 : 1/"+rp[3]+
				", 4등 : 1/"+rp[4]+", 5등 : 1/"+rp[5]+"  미당첨 : 1/"+rp[0]);
		System.out.println("------------------------------------------");
		

		return r;
	}
	
	public Integer[] addArr(Integer[] a, Integer[] tempResult) {
		Integer[] added = new Integer[a.length];
		for (int i = 0; i<added.length; i++) added[i] = a[i]+tempResult[i];
		return added;
	}
	
}