package ui;


import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import predictorModel.FrequencyPredictor;
import predictorModel.PredictorModel;
import predictorModel.UnfrequencyPredictor;
import lottoCollection.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class uiController implements Initializable {

	public TextArea promptText;
	public ComboBox<String> comboBox;
	
	public TextField inputFrom;
	public TextField inputTo;
	public TextField inputRange;
	public TextField inputPick;
	
	//public TableView resultTable;
	
	public Label mathCount1st;
	public Label mathCount2nd;
	public Label mathCount3rd;
	public Label mathCount4th;
	public Label mathCount5th;
	public Label mathCountAll;
	public Label resultCount1st;
	public Label resultCount2nd;
	public Label resultCount3rd;
	public Label resultCount4th;
	public Label resultCount5th;
	public Label resultCountAll;
	public Label resultProb1;
	public Label resultProb2;
	public Label resultProb3;
	public Label resultProb4;
	public Label resultProb5;
	public Label resultProbAll;
	public Label improved1;
	public Label improved2;
	public Label improved3;
	public Label improved4;
	public Label improved5;
	public Label improvedAll;
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
        setPromptText("Loading Lotto History . . .");
        setPromptText("Lotto History loaded");
        
        comboBox.getItems().addAll(
        		"Random Model",
        		"Frequency Predictor",
        		"Unfrequency Predictor",
        		"Follow Predictor",
        		"Difference Predictor",
        		"Synthetic Predictor"
        		);
        
        
    }
    
    
    public void analyze() {
    	
    	comboBox.setDisable(true);
    	inputFrom.setDisable(true);
    	inputTo.setDisable(true);
    	inputRange.setDisable(true);
    	inputPick.setDisable(true);
    	
    	String currModel = comboBox.getId();
    	int from = Integer.parseInt(inputFrom.getText());
    	int to = Integer.parseInt(inputTo.getText());
    	int range = Integer.parseInt(inputRange.getText());
    	int pick = Integer.parseInt(inputPick.getText());
    	
    	setPromptText("Starting to Analyze with "+currModel+"  from "+from+" to "+to+"  range "+range+"  pick "+pick);
    	
    	setMathResult(from, to, pick);
    	
    	PredictorModel p = null;
		Compare c = new Compare();
		Integer[] result = new Integer[7];
		ArrayList<Integer[]> resultList = new ArrayList<Integer[]>();
    	
		MainRunner.getLH().printOut();
		
    	switch(currModel) {
	    	case "Random Model" :{
	    		
			}
	    	case "Frequency Predictor" :{
				p = new FrequencyPredictor(MainRunner.getLH(), from, to, range, pick);
			}
	    	case "Unfrequency Predictor" :{
	    		//p = new UnfrequencyPredictor(MainRunner.getLH(), from, to, range, pick);
			}
	    	case "Follow Predictor" :{
				
			}
	    	case "Difference Predictor" :{
				
			}
	    	case "Synthetic Predictor" :{
	    		
	    	}
    	}
		ArrayList<ArrayList<LottoNumber>> tempPrediction = p.generate();
		setPromptText("generated " + (from-to)*pick + "number sets...");
		for(int i = from; i < to; i++) {
			LottoNumber tempNum = MainRunner.getLH().getMyHis().get(i);
			Integer[] tempResult = (Integer[]) c.compare(tempPrediction.get(i), tempNum);
			c.addArr(result, tempResult);
			resultList.add(tempResult);
			setPromptText("Analyzed " + resultList.size() +"turn...");
		}
		updateResult(result);
		
    	comboBox.setDisable(false);
    	inputFrom.setDisable(false);
    	inputTo.setDisable(false);
    	inputRange.setDisable(false);
    	inputPick.setDisable(false);
    	System.out.println("done");
    	setPromptText("finished");
	}
    
    public void updateResult(Integer[] result) {
    		resultCount1st.setText(result[1]+"");
    		resultCount2nd.setText(result[2]+"");
    		resultCount3rd.setText(result[3]+"");
    		resultCount4th.setText(result[4]+"");
    		resultCount5th.setText(result[5]+"");
    		resultCountAll.setText(result[6]+"");
    }
    
	public void setMathResult(int from, int to, int pick) {
    	int turnAll = to-from+1;
    	int pickAll = pick*turnAll;
    	
    	ArrayList<String> resultAll = new ArrayList<String>();
    	
    	resultAll.add(Double.toString(1.0/8145060.0*pickAll));
    	resultAll.add(Double.toString(1.0/1357510.0*pickAll));
    	resultAll.add(Double.toString(1.0/35724.0*pickAll));
    	resultAll.add(Double.toString(1.0/733.0*pickAll));
    	resultAll.add(Double.toString(1.0/45.0*pickAll));
    	resultAll.add(Double.toString(0.0857*pickAll));
    	
    	for(String s : resultAll) {
    		System.out.println(s);
    	}

    	for(int i = 0; i < resultAll.size(); i++) {
        	int tempidx = resultAll.get(i).indexOf('.');
        	resultAll.set(i, resultAll.get(i).substring(0,tempidx+2));
    	}

    	mathCount1st.setText(resultAll.get(0));
    	mathCount2nd.setText(resultAll.get(1));
    	mathCount3rd.setText(resultAll.get(2));
    	mathCount4th.setText(resultAll.get(3));
    	mathCount5th.setText(resultAll.get(4));
    	mathCountAll.setText(resultAll.get(5));
    }
    
    public void setPromptText(String input) {
    	promptText.setText(input);
    }
    
    public void changeMenu() {
    	System.out.println("changeMenu is active. . . ");
    }
}