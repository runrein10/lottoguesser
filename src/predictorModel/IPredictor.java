package predictorModel;

import java.util.ArrayList;
import lottoCollection.*;

public interface IPredictor {
	
	public ArrayList<LottoNumber> generate(LottoHistory LH);
	
	public ArrayList<ArrayList<LottoNumber>> generate();
	
}
